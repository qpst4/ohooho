package defpackage;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class e21 extends View {
    public final int b;

    public e21(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = (int) TypedValue.applyDimension(1, 200.0f, context.getResources().getDisplayMetrics());
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode == 0) {
            size = size2;
        } else if (mode2 != 0) {
            size = Math.min(size, size2);
        }
        int iMax = Math.max(size, this.b);
        setMeasuredDimension(iMax, iMax);
    }
}
