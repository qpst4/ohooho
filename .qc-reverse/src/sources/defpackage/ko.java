package defpackage;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.GestureDescription;
import android.graphics.Path;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ko extends AccessibilityService.GestureResultCallback {
    public final AccessibilityService a;
    public final List b;
    public final lk0 c;
    public boolean e;
    public int d = 0;
    public GestureDescription.StrokeDescription f = null;

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00e7, code lost:
    
        if (android.os.Build.VERSION.SDK_INT < 26) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00e9, code lost:
    
        a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00ec, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00ed, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00f0, code lost:
    
        b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00f3, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00f4, code lost:
    
        defpackage.si0.a("ContinuousGestureDispatcher exception: " + r0);
        r8.c.run();
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x010a, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ko(android.accessibilityservice.AccessibilityService r9, java.util.concurrent.CopyOnWriteArrayList r10, defpackage.lk0 r11) {
        /*
            Method dump skipped, instruction units count: 267
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ko.<init>(android.accessibilityservice.AccessibilityService, java.util.concurrent.CopyOnWriteArrayList, lk0):void");
    }

    public final void a() {
        List list = this.b;
        this.e = 1 < list.size() - 1;
        t51 t51Var = (t51) list.get(0);
        t51 t51Var2 = (t51) list.get(1);
        boolean z = t51Var.a == t51Var2.a && t51Var.b == t51Var2.b;
        boolean z2 = t51Var.c == 0;
        GestureDescription.Builder builder = new GestureDescription.Builder();
        Path path = new Path();
        path.moveTo(t51Var.a, t51Var.b);
        long j = t51Var2.c;
        boolean z3 = j == 0;
        if ((!z2 && z && this.e) || z3) {
            this.d = (int) (((long) this.d) + j);
            onCompleted(null);
            return;
        }
        if (z) {
            t51Var2.b++;
        }
        path.lineTo(t51Var2.a, t51Var2.b);
        GestureDescription.StrokeDescription strokeDescription = this.f;
        if (strokeDescription == null) {
            this.f = c0.e(path, this.d, t51Var2.c, this.e);
        } else {
            this.f = strokeDescription.continueStroke(path, this.d, t51Var2.c, this.e);
        }
        this.d = 0;
        builder.addStroke(this.f);
        if (l60.i(this.a, builder.build(), this)) {
            return;
        }
        this.c.run();
    }

    public final void b() {
        GestureDescription.Builder builder = new GestureDescription.Builder();
        Path path = new Path();
        int i = 0;
        for (t51 t51Var : this.b) {
            long j = t51Var.c;
            int i2 = t51Var.a;
            int i3 = t51Var.b;
            if (j == 0) {
                path.moveTo(i2, i3);
            } else {
                path.lineTo(i2, i3);
            }
            i = (int) (((long) i) + t51Var.c);
        }
        builder.addStroke(new GestureDescription.StrokeDescription(path, 0L, i));
        this.e = false;
        if (l60.i(this.a, builder.build(), this)) {
            return;
        }
        this.c.run();
    }

    @Override // android.accessibilityservice.AccessibilityService.GestureResultCallback
    public final void onCancelled(GestureDescription gestureDescription) {
        this.c.run();
    }

    @Override // android.accessibilityservice.AccessibilityService.GestureResultCallback
    public final void onCompleted(GestureDescription gestureDescription) {
        boolean z = this.e;
        lk0 lk0Var = this.c;
        if (!z) {
            lk0Var.run();
            return;
        }
        List list = this.b;
        if (list.size() <= 0) {
            lk0Var.run();
        } else {
            list.remove(0);
            a();
        }
    }
}
