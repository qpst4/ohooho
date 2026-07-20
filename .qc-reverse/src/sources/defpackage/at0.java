package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.quickcursor.R;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class at0 extends ConstraintLayout {
    public final lk0 r;
    public int s;
    public final ik0 t;

    public at0(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.materialClockStyle);
        LayoutInflater.from(context).inflate(R.layout.material_radial_view_group, this);
        ik0 ik0Var = new ik0();
        this.t = ik0Var;
        hv0 hv0Var = new hv0(0.5f);
        lz0 lz0VarF = ik0Var.b.a.f();
        lz0VarF.e = hv0Var;
        lz0VarF.f = hv0Var;
        lz0VarF.g = hv0Var;
        lz0VarF.h = hv0Var;
        ik0Var.setShapeAppearanceModel(lz0VarF.a());
        this.t.k(ColorStateList.valueOf(-1));
        ik0 ik0Var2 = this.t;
        WeakHashMap weakHashMap = uf1.a;
        setBackground(ik0Var2);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ys0.x, R.attr.materialClockStyle, 0);
        this.s = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.r = new lk0(5, this);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (view.getId() == -1) {
            WeakHashMap weakHashMap = uf1.a;
            view.setId(View.generateViewId());
        }
        Handler handler = getHandler();
        if (handler != null) {
            lk0 lk0Var = this.r;
            handler.removeCallbacks(lk0Var);
            handler.post(lk0Var);
        }
    }

    public abstract void m();

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        m();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public final void onViewRemoved(View view) {
        super.onViewRemoved(view);
        Handler handler = getHandler();
        if (handler != null) {
            lk0 lk0Var = this.r;
            handler.removeCallbacks(lk0Var);
            handler.post(lk0Var);
        }
    }

    @Override // android.view.View
    public final void setBackgroundColor(int i) {
        this.t.k(ColorStateList.valueOf(i));
    }
}
