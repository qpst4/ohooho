package defpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.appcompat.widget.AppCompatImageView;
import com.quickcursor.R;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class z1 extends AppCompatImageView implements b2 {
    public final /* synthetic */ a2 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z1(a2 a2Var, Context context) {
        super(context, null, R.attr.actionOverflowButtonStyle);
        this.e = a2Var;
        setClickable(true);
        setFocusable(true);
        setVisibility(0);
        setEnabled(true);
        fc0.P(this, getContentDescription());
        setOnTouchListener(new v1(this, this));
    }

    @Override // defpackage.b2
    public final boolean a() {
        return false;
    }

    @Override // defpackage.b2
    public final boolean b() {
        return false;
    }

    @Override // android.view.View
    public final boolean performClick() {
        if (super.performClick()) {
            return true;
        }
        playSoundEffect(0);
        this.e.l();
        return true;
    }

    @Override // android.widget.ImageView
    public final boolean setFrame(int i, int i2, int i3, int i4) {
        boolean frame = super.setFrame(i, i2, i3, i4);
        Drawable drawable = getDrawable();
        Drawable background = getBackground();
        if (drawable != null && background != null) {
            int width = getWidth();
            int height = getHeight();
            int iMax = Math.max(width, height) / 2;
            int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
            int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
            background.setHotspotBounds(paddingLeft - iMax, paddingTop - iMax, paddingLeft + iMax, paddingTop + iMax);
        }
        return frame;
    }
}
