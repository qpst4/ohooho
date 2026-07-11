package com.slideindex.app.shizuku

import com.slideindex.app.util.TaskExclusions
import java.util.regex.Pattern

internal object TaskShellParserPatterns {
    val RECENT_TASK_ID = Pattern.compile(
        "(?:Recent #\\d+: )?Task(?:Record)?\\{[^#]*#(\\d+)\\b",
    )
    val RECENT_A_FIELD = Pattern.compile("[\\s{]A=(?:\\d+:)?([^\\s}/]+)")
    val RECENT_COMPONENT_FIELD = Pattern.compile("[\\s{](?:I|aI)=([^\\s}/]+)")
    val CMP_FIELD = Pattern.compile("cmp=([\\w.]+)/")
    val TASK_ID_HEADER = Pattern.compile("Task id #(\\d+)")
    val CMD_TASK_HEADER = Pattern.compile("^\\*?\\s*TASK\\s+(\\d+):\\s*([\\w.]+)")
    val TASK_ID_FIELD = Pattern.compile("\\btaskId=(\\d+)\\b")
    val TASK_ID_LINE = Pattern.compile("Task id #(\\d+)")
    val PACKAGE_NAME_FIELD = Pattern.compile("(?:packageName|realActivity|baseActivity)=([\\w.]+)")
    val RESUMED_ACTIVITY = Pattern.compile(
        "(?:mResumedActivity|ResumedActivity|topResumedActivity)[^\\n]*\\bt(\\d+)\\b",
    )
    val GENERIC_TASK_ID = Pattern.compile("\\bt(\\d+)\\b")
    val GENERIC_HASH_ID = Pattern.compile("#(\\d+)")
    val TASK_RECORD_HEADER = Pattern.compile(
        "Task(?:Record)?\\{[^#]*#(\\d+)\\b[^}]*(?:A=(?:\\d+:)?([^\\s}/]+)|(?:I|aI)=([^\\s}/]+))",
    )
    val TASK_DESC_LABEL = Pattern.compile("""taskDescription.*\blabel="([^"]+)"""")
    val TASK_DESC_LABEL_PLAIN = Pattern.compile("""taskDescription.*\blabel=([^\s},]+)""")
    val TASK_TITLE_QUOTED = Pattern.compile("""\btitle="([^"]+)"""")
    val TASK_TITLE_PLAIN = Pattern.compile("""\btitle=([^\s},]+)""")
    val TASK_DESC_LABEL_CN = Pattern.compile("""\b(?:lastDescription|description|contentTitle|mLabel)="([^"]+)"""")
    val TASK_DESC_LABEL_CN_PLAIN = Pattern.compile("""\b(?:lastDescription|description|contentTitle|mLabel)=([^\s},]+)""")
    val ACTIVITY_RECORD_COMPONENT = Pattern.compile(
        "ActivityRecord\\{[^}]*? u\\d+ ([^\\s}]+) t(\\d+)\\b",
    )
    val HIST_ACTIVITY_COMPONENT = Pattern.compile(
        "Hist #\\d+: ActivityRecord\\{[^}]*? u\\d+ ([^\\s}]+) t(\\d+)\\b",
    )
    val M_LAST_TASK_DESC = Pattern.compile(
        "mLastTaskDescription=TaskDescription\\s*\\{[^}]*?label=\"([^\"]+)\"",
    )
    val REAL_ACTIVITY_FIELD = Pattern.compile("realActivity=([^\\s}/]+(?:/[^\\s}/]+)?)")
    val TOP_ACTIVITY_FIELD = Pattern.compile("(?:topActivity|mTopActivity|resumedActivity)=")

    val EXCLUDED_PACKAGES = TaskExclusions.LAUNCHER_AND_SYSTEM
}
