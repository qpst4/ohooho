package defpackage;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class eq0 extends wt0 {
    public Drawable a;
    public int b;
    public boolean c = true;
    public final /* synthetic */ gq0 d;

    public eq0(gq0 gq0Var) {
        this.d = gq0Var;
    }

    @Override // defpackage.wt0
    public final void d(Rect rect, View view, RecyclerView recyclerView) {
        if (g(view, recyclerView)) {
            rect.bottom = this.b;
        }
    }

    @Override // defpackage.wt0
    public final void f(Canvas canvas, RecyclerView recyclerView) {
        if (this.a == null) {
            return;
        }
        int childCount = recyclerView.getChildCount();
        int width = recyclerView.getWidth();
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            if (g(childAt, recyclerView)) {
                int height = childAt.getHeight() + ((int) childAt.getY());
                this.a.setBounds(0, height, width, this.b + height);
                this.a.draw(canvas);
            }
        }
    }

    public final boolean g(View view, RecyclerView recyclerView) {
        pu0 pu0VarI = recyclerView.I(view);
        if (!(pu0VarI instanceof nq0) || !((nq0) pu0VarI).x) {
            return false;
        }
        boolean z = this.c;
        int iIndexOfChild = recyclerView.indexOfChild(view);
        if (iIndexOfChild >= recyclerView.getChildCount() - 1) {
            return z;
        }
        pu0 pu0VarI2 = recyclerView.I(recyclerView.getChildAt(iIndexOfChild + 1));
        return (pu0VarI2 instanceof nq0) && ((nq0) pu0VarI2).w;
    }
}
