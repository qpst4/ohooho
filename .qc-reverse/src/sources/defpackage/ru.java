package defpackage;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ru {
    public static final boolean a;
    public static final Method b;
    public static final Field c;
    public static final Field d;
    public static final Field e;
    public static final Field f;

    /* JADX WARN: Removed duplicated region for block: B:25:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0057  */
    static {
        /*
            r0 = 1
            r1 = 0
            r2 = 0
            java.lang.String r3 = "android.graphics.Insets"
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch: java.lang.NoSuchFieldException -> L3d java.lang.ClassNotFoundException -> L40 java.lang.NoSuchMethodException -> L43
            java.lang.Class<android.graphics.drawable.Drawable> r4 = android.graphics.drawable.Drawable.class
            java.lang.String r5 = "getOpticalInsets"
            java.lang.reflect.Method r4 = r4.getMethod(r5, r1)     // Catch: java.lang.NoSuchFieldException -> L3d java.lang.ClassNotFoundException -> L40 java.lang.NoSuchMethodException -> L43
            java.lang.String r5 = "left"
            java.lang.reflect.Field r5 = r3.getField(r5)     // Catch: java.lang.NoSuchFieldException -> L34 java.lang.ClassNotFoundException -> L37 java.lang.NoSuchMethodException -> L3a
            java.lang.String r6 = "top"
            java.lang.reflect.Field r6 = r3.getField(r6)     // Catch: java.lang.NoSuchFieldException -> L2d java.lang.ClassNotFoundException -> L30 java.lang.NoSuchMethodException -> L32
            java.lang.String r7 = "right"
            java.lang.reflect.Field r7 = r3.getField(r7)     // Catch: java.lang.Throwable -> L2b
            java.lang.String r8 = "bottom"
            java.lang.reflect.Field r3 = r3.getField(r8)     // Catch: java.lang.Throwable -> L46
            r8 = r0
            goto L48
        L2b:
            r7 = r1
            goto L46
        L2d:
            r6 = r1
        L2e:
            r7 = r6
            goto L46
        L30:
            r6 = r1
            goto L2e
        L32:
            r6 = r1
            goto L2e
        L34:
            r5 = r1
        L35:
            r6 = r5
            goto L2e
        L37:
            r5 = r1
        L38:
            r6 = r5
            goto L2e
        L3a:
            r5 = r1
        L3b:
            r6 = r5
            goto L2e
        L3d:
            r4 = r1
            r5 = r4
            goto L35
        L40:
            r4 = r1
            r5 = r4
            goto L38
        L43:
            r4 = r1
            r5 = r4
            goto L3b
        L46:
            r3 = r1
            r8 = r2
        L48:
            if (r8 == 0) goto L57
            defpackage.ru.b = r4
            defpackage.ru.c = r5
            defpackage.ru.d = r6
            defpackage.ru.e = r7
            defpackage.ru.f = r3
            defpackage.ru.a = r0
            goto L63
        L57:
            defpackage.ru.b = r1
            defpackage.ru.c = r1
            defpackage.ru.d = r1
            defpackage.ru.e = r1
            defpackage.ru.f = r1
            defpackage.ru.a = r2
        L63:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ru.<clinit>():void");
    }
}
