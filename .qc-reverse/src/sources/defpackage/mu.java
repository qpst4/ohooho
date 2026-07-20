package defpackage;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class mu extends wt0 {
    public static final int[] d = {R.attr.listDivider};
    public final Drawable a;
    public final int b;
    public final Rect c = new Rect();

    public mu(Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(d);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(0);
        this.a = drawable;
        if (drawable == null) {
            Log.w("DividerItem", "@android:attr/listDivider was not set in the theme used for this DividerItemDecoration. Please set that attribute all call setDrawable()");
        }
        typedArrayObtainStyledAttributes.recycle();
        this.b = 1;
    }

    @Override // defpackage.wt0
    public final void d(Rect rect, View view, RecyclerView recyclerView) {
        Drawable drawable = this.a;
        if (drawable == null) {
            rect.set(0, 0, 0, 0);
        } else if (this.b == 1) {
            rect.set(0, 0, 0, drawable.getIntrinsicHeight());
        } else {
            rect.set(0, 0, drawable.getIntrinsicWidth(), 0);
        }
    }

    @Override // defpackage.wt0
    public final void e(Canvas canvas, RecyclerView recyclerView) {
        Drawable drawable;
        int height;
        int paddingTop;
        int width;
        int paddingLeft;
        if (recyclerView.getLayoutManager() == null || (drawable = this.a) == null) {
            return;
        }
        int i = 0;
        int i2 = this.b;
        Rect rect = this.c;
        if (i2 == 1) {
            canvas.save();
            if (recyclerView.getClipToPadding()) {
                paddingLeft = recyclerView.getPaddingLeft();
                width = recyclerView.getWidth() - recyclerView.getPaddingRight();
                canvas.clipRect(paddingLeft, recyclerView.getPaddingTop(), width, recyclerView.getHeight() - recyclerView.getPaddingBottom());
            } else {
                width = recyclerView.getWidth();
                paddingLeft = 0;
            }
            int childCount = recyclerView.getChildCount();
            while (i < childCount) {
                View childAt = recyclerView.getChildAt(i);
                RecyclerView.K(rect, childAt);
                int iRound = Math.round(childAt.getTranslationY()) + rect.bottom;
                drawable.setBounds(paddingLeft, iRound - drawable.getIntrinsicHeight(), width, iRound);
                drawable.draw(canvas);
                i++;
            }
            canvas.restore();
            return;
        }
        canvas.save();
        if (recyclerView.getClipToPadding()) {
            paddingTop = recyclerView.getPaddingTop();
            height = recyclerView.getHeight() - recyclerView.getPaddingBottom();
            canvas.clipRect(recyclerView.getPaddingLeft(), paddingTop, recyclerView.getWidth() - recyclerView.getPaddingRight(), height);
        } else {
            height = recyclerView.getHeight();
            paddingTop = 0;
        }
        int childCount2 = recyclerView.getChildCount();
        while (i < childCount2) {
            View childAt2 = recyclerView.getChildAt(i);
            recyclerView.getLayoutManager().z(rect, childAt2);
            int iRound2 = Math.round(childAt2.getTranslationX()) + rect.right;
            drawable.setBounds(iRound2 - drawable.getIntrinsicWidth(), paddingTop, iRound2, height);
            drawable.draw(canvas);
            i++;
        }
        canvas.restore();
    }
}
