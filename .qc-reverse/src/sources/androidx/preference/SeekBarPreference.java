package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.AbsSavedState;
import android.widget.SeekBar;
import android.widget.TextView;
import com.quickcursor.R;
import defpackage.nq0;
import defpackage.sy0;
import defpackage.ty0;
import defpackage.uy0;
import defpackage.vs0;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class SeekBarPreference extends Preference {
    public int O;
    public int P;
    public int Q;
    public int R;
    public boolean S;
    public SeekBar T;
    public TextView U;
    public final boolean V;
    public final boolean W;
    public final boolean X;
    public final sy0 Y;
    public final ty0 Z;

    public SeekBarPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.seekBarPreferenceStyle, 0);
        this.Y = new sy0(this);
        this.Z = new ty0(this);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, vs0.k, R.attr.seekBarPreferenceStyle, 0);
        this.P = typedArrayObtainStyledAttributes.getInt(3, 0);
        int i = typedArrayObtainStyledAttributes.getInt(1, 100);
        int i2 = this.P;
        i = i < i2 ? i2 : i;
        if (i != this.Q) {
            this.Q = i;
            k();
        }
        int i3 = typedArrayObtainStyledAttributes.getInt(4, 0);
        if (i3 != this.R) {
            this.R = Math.min(this.Q - this.P, Math.abs(i3));
            k();
        }
        this.V = typedArrayObtainStyledAttributes.getBoolean(2, true);
        this.W = typedArrayObtainStyledAttributes.getBoolean(5, false);
        this.X = typedArrayObtainStyledAttributes.getBoolean(6, false);
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void J(int i, boolean z) {
        int i2 = this.P;
        if (i < i2) {
            i = i2;
        }
        int i3 = this.Q;
        if (i > i3) {
            i = i3;
        }
        if (i != this.O) {
            this.O = i;
            TextView textView = this.U;
            if (textView != null) {
                textView.setText(String.valueOf(i));
            }
            y(i);
            if (z) {
                k();
            }
        }
    }

    public final void K(SeekBar seekBar) {
        int progress = seekBar.getProgress() + this.P;
        if (progress != this.O) {
            if (a(Integer.valueOf(progress))) {
                J(progress, false);
                return;
            }
            seekBar.setProgress(this.O - this.P);
            int i = this.O;
            TextView textView = this.U;
            if (textView != null) {
                textView.setText(String.valueOf(i));
            }
        }
    }

    @Override // androidx.preference.Preference
    public final void o(nq0 nq0Var) {
        super.o(nq0Var);
        nq0Var.a.setOnKeyListener(this.Z);
        this.T = (SeekBar) nq0Var.r(R.id.seekbar);
        TextView textView = (TextView) nq0Var.r(R.id.seekbar_value);
        this.U = textView;
        if (this.W) {
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
            this.U = null;
        }
        SeekBar seekBar = this.T;
        if (seekBar == null) {
            Log.e("SeekBarPreference", "SeekBar view is null in onBindViewHolder.");
            return;
        }
        seekBar.setOnSeekBarChangeListener(this.Y);
        this.T.setMax(this.Q - this.P);
        int i = this.R;
        SeekBar seekBar2 = this.T;
        if (i != 0) {
            seekBar2.setKeyProgressIncrement(i);
        } else {
            this.R = seekBar2.getKeyProgressIncrement();
        }
        this.T.setProgress(this.O - this.P);
        int i2 = this.O;
        TextView textView2 = this.U;
        if (textView2 != null) {
            textView2.setText(String.valueOf(i2));
        }
        this.T.setEnabled(j());
    }

    @Override // androidx.preference.Preference
    public final Object r(TypedArray typedArray, int i) {
        return Integer.valueOf(typedArray.getInt(i, 0));
    }

    @Override // androidx.preference.Preference
    public final void s(Parcelable parcelable) {
        if (!parcelable.getClass().equals(uy0.class)) {
            super.s(parcelable);
            return;
        }
        uy0 uy0Var = (uy0) parcelable;
        super.s(uy0Var.getSuperState());
        this.O = uy0Var.b;
        this.P = uy0Var.c;
        this.Q = uy0Var.d;
        k();
    }

    @Override // androidx.preference.Preference
    public final Parcelable t() {
        super.t();
        AbsSavedState absSavedState = AbsSavedState.EMPTY_STATE;
        if (this.s) {
            return absSavedState;
        }
        uy0 uy0Var = new uy0();
        uy0Var.b = this.O;
        uy0Var.c = this.P;
        uy0Var.d = this.Q;
        return uy0Var;
    }

    @Override // androidx.preference.Preference
    public final void u(Object obj) {
        if (obj == null) {
            obj = 0;
        }
        J(f(((Integer) obj).intValue()), true);
    }
}
