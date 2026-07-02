package com.slideindex.app.shizuku

import android.content.ComponentName
import android.content.Intent

/** Minimal reflection helpers for system TaskInfo / ActivityManager stubs. */
internal object SystemReflect {

    fun invoke(target: Any, method: String): Any? =
        runCatching { target.javaClass.getMethod(method).invoke(target) }.getOrNull()

    fun invoke(target: Any, method: String, vararg args: Any?): Any? =
        runCatching {
            val types = args.map { arg ->
                when (arg) {
                    is Int -> Int::class.javaPrimitiveType!!
                    is Boolean -> Boolean::class.javaPrimitiveType!!
                    is Long -> Long::class.javaPrimitiveType!!
                    null -> Any::class.java
                    else -> arg.javaClass
                }
            }.toTypedArray()
            target.javaClass.getMethod(method, *types).invoke(target, *args)
        }.getOrNull()

    fun readField(target: Any, name: String): Any? {
        var clazz: Class<*>? = target.javaClass
        while (clazz != null) {
            val value = runCatching {
                val field = clazz.getDeclaredField(name)
                field.isAccessible = true
                field.get(target)
            }.getOrNull()
            if (value != null) return value
            clazz = clazz.superclass
        }
        return null
    }

    fun readInt(target: Any, vararg names: String): Int? {
        for (name in names) {
            when {
                name.startsWith("get") -> {
                    when (val value = invoke(target, name)) {
                        is Int -> return value
                        is Number -> return value.toInt()
                    }
                }
                else -> {
                    when (val value = readField(target, name)) {
                        is Int -> return value
                        is Number -> return value.toInt()
                        else -> value?.toString()?.toIntOrNull()?.let { return it }
                    }
                }
            }
        }
        return null
    }

    fun readString(target: Any, vararg names: String): String? {
        for (name in names) {
            val value = if (name.startsWith("get")) invoke(target, name) else readField(target, name)
            value?.toString()?.trim()?.takeIf { it.isNotEmpty() }?.let { return it }
        }
        return null
    }

    fun readCharSequence(target: Any, vararg names: String): CharSequence? {
        for (name in names) {
            val value = if (name.startsWith("get")) invoke(target, name) else readField(target, name)
            (value as? CharSequence)?.let { return it }
        }
        return null
    }

    fun readComponent(target: Any, vararg names: String): ComponentName? {
        for (name in names) {
            val value = if (name.startsWith("get")) invoke(target, name) else readField(target, name)
            when (value) {
                is ComponentName -> return value
                is String -> parseComponent(value)?.let { return it }
                null -> continue
                else -> {
                    readString(value, "flattenToShortString")?.let { parseComponent(it) }?.let { return it }
                    val pkg = readString(value, "packageName")
                    val cls = readString(value, "className", "name")
                    if (!pkg.isNullOrBlank() && !cls.isNullOrBlank()) {
                        return ComponentName(pkg, cls)
                    }
                }
            }
        }
        return null
    }

    fun readComponentFromInfo(task: Any, vararg infoFields: String): ComponentName? {
        for (field in infoFields) {
            val info = readField(task, field) ?: continue
            val pkg = readString(info, "packageName") ?: continue
            val cls = readString(info, "name") ?: continue
            return ComponentName(pkg, cls)
        }
        return null
    }

    fun unwrapList(result: Any?): List<Any>? {
        when (result) {
            null -> return null
            is List<*> -> return result.filterNotNull()
            is Array<*> -> return result.filterNotNull()
        }
        return runCatching {
            invoke(result, "getList") as? List<*>
        }.getOrNull()?.filterNotNull()
    }

    private fun parseComponent(raw: String): ComponentName? {
        val trimmed = raw.trim()
        if (trimmed.isEmpty() || !trimmed.contains('/')) return null
        val parts = trimmed.split('/', limit = 2)
        if (parts.size == 2 && parts[0].contains('.')) {
            return ComponentName(parts[0], parts[1].removePrefix("."))
        }
        return null
    }
}
