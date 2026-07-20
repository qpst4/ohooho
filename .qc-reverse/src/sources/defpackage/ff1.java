package defpackage;

import android.graphics.Canvas;
import android.view.View;
import com.quickcursor.android.drawables.globals.RippleDrawable;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ff1 extends View {
    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        CopyOnWriteArrayList<kg0> copyOnWriteArrayList = r60.e;
        CopyOnWriteArrayList<RippleDrawable> copyOnWriteArrayList2 = r60.d;
        boolean z = true;
        boolean zA = (System.currentTimeMillis() < 0) | r60.a(canvas, r60.g) | r60.a(canvas, r60.m) | r60.a(canvas, r60.j) | r60.a(canvas, r60.k) | r60.a(canvas, r60.n);
        for (RippleDrawable rippleDrawable : copyOnWriteArrayList2) {
            if (rippleDrawable.a()) {
                copyOnWriteArrayList2.remove(rippleDrawable);
            } else {
                rippleDrawable.draw(canvas);
                zA = true;
            }
        }
        for (kg0 kg0Var : copyOnWriteArrayList) {
            if (kg0Var.a()) {
                copyOnWriteArrayList.remove(kg0Var);
            } else {
                kg0Var.draw(canvas);
                zA = true;
            }
        }
        boolean zA2 = r60.a(canvas, r60.l) | zA | r60.a(canvas, r60.h) | r60.a(canvas, r60.i) | r60.a(canvas, r60.o);
        Iterator it = r60.p.values().iterator();
        while (it.hasNext()) {
            zA2 |= r60.a(canvas, (s91) it.next());
        }
        boolean zA3 = zA2 | r60.a(canvas, r60.r);
        if (r60.s) {
            x00 x00Var = r60.f;
            x00Var.getClass();
            long jNanoTime = System.nanoTime();
            if (x00Var.e) {
                x00Var.d = jNanoTime;
                x00Var.f = 1;
                x00Var.g = 0;
                x00Var.e = false;
            } else {
                int i = x00Var.f;
                if (i == x00Var.h) {
                    x00Var.g = (int) ((((double) i) / ((double) ((jNanoTime - x00Var.d) / 1000000.0f))) * 1000.0d);
                    x00Var.d = jNanoTime;
                    x00Var.f = 1;
                } else {
                    x00Var.f = i + 1;
                }
            }
            canvas.drawText(" FPS: " + x00Var.g, x00Var.b, x00Var.c, x00Var.a);
        } else {
            z = zA3;
        }
        if (z) {
            invalidate();
        }
    }

    public View getView() {
        return this;
    }
}
