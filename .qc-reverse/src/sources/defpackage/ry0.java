package defpackage;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import com.quickcursor.R;
import com.quickcursor.android.preferences.SeekBarDialogPreference;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class ry0 extends dq0 implements SeekBar.OnSeekBarChangeListener, TextWatcher {
    public int A0;
    public int B0;
    public int C0;
    public int D0;
    public boolean E0;
    public boolean F0;
    public boolean G0;
    public boolean H0;
    public boolean I0;
    public int J0;
    public SeekBarDialogPreference w0;
    public EditText x0;
    public EditText y0;
    public SeekBar z0;

    @Override // defpackage.dq0, defpackage.wt, defpackage.j30
    public final void J(Bundle bundle) {
        super.J(bundle);
        SeekBarDialogPreference seekBarDialogPreference = (SeekBarDialogPreference) k0();
        this.w0 = seekBarDialogPreference;
        if (seekBarDialogPreference == null) {
            return;
        }
        this.D0 = seekBarDialogPreference.d0;
        int i = seekBarDialogPreference.a0;
        this.A0 = i;
        int i2 = seekBarDialogPreference.Z;
        this.B0 = i2;
        int i3 = seekBarDialogPreference.c0;
        this.C0 = i3;
        this.G0 = i2 % i == 0;
        this.F0 = i3 % i == 0;
        this.H0 = (i3 - i2) % i == 0;
        this.E0 = seekBarDialogPreference.W;
    }

    @Override // defpackage.dq0
    public final void m0(boolean z) {
        int iMax = this.D0;
        try {
            iMax = Integer.parseInt(this.x0.getText().toString());
        } catch (Exception unused) {
        }
        int i = this.J0;
        if (i == -2) {
            iMax = this.D0;
        }
        if (i == -3) {
            iMax = Math.max(this.w0.b0, this.B0);
        }
        SeekBarDialogPreference seekBarDialogPreference = this.w0;
        if (seekBarDialogPreference.a(Integer.valueOf(Math.min(seekBarDialogPreference.c0, Math.max(seekBarDialogPreference.Z, iMax))))) {
            this.w0.L(iMax);
        }
    }

    @Override // defpackage.dq0
    public final void n0(jl1 jl1Var) {
        x6 x6Var = (x6) jl1Var.c;
        if (this.w0 == null) {
            h0(false, false);
            return;
        }
        View viewInflate = ((LayoutInflater) u().getSystemService("layout_inflater")).inflate(R.layout.seek_bar_dialog_preference, (ViewGroup) null);
        x6Var.u = viewInflate;
        this.x0 = (EditText) viewInflate.findViewById(R.id.sbdp_value);
        this.y0 = (EditText) viewInflate.findViewById(R.id.dp_value);
        this.z0 = (SeekBar) viewInflate.findViewById(R.id.sbdp_seekBar);
        SeekBarDialogPreference seekBarDialogPreference = this.w0;
        int i = seekBarDialogPreference.d0;
        String str = seekBarDialogPreference.U;
        TextView textView = (TextView) viewInflate.findViewById(R.id.sbdp_description);
        if (str == null || str.length() == 0) {
            textView.setPadding(0, 0, 0, 0);
            textView.setVisibility(8);
        } else {
            textView.setText(str);
        }
        this.I0 = "px".equalsIgnoreCase(this.w0.V);
        viewInflate.findViewById(R.id.linearLayoutDp).setVisibility(this.I0 ? 0 : 8);
        ((TextView) viewInflate.findViewById(R.id.sbdp_units)).setText(this.w0.V);
        ((TextView) viewInflate.findViewById(R.id.sbdp_min)).setText(this.B0 + "");
        ((TextView) viewInflate.findViewById(R.id.sbd_max)).setText(this.C0 + "");
        SeekBar seekBar = this.z0;
        int i2 = (this.C0 - this.B0) / this.A0;
        boolean z = this.G0;
        if (!z) {
            i2++;
        }
        boolean z2 = this.F0;
        if (!z2) {
            i2++;
        }
        if (!z && !z2 && this.H0) {
            i2--;
        }
        seekBar.setMax(i2);
        this.z0.setOnSeekBarChangeListener(this);
        this.x0.addTextChangedListener(this);
        this.y0.addTextChangedListener(this);
        p0(i);
        q0(i);
        x6Var.e = this.w0.i;
        jl1Var.k(R.string.dialog_button_done, this);
        jl1Var.h(R.string.dialog_button_cancel, this);
        if (this.w0.X) {
            return;
        }
        jl1Var.i(R.string.dialog_button_default, this);
    }

    public final void o0(int i) {
        if (this.E0) {
            SeekBarDialogPreference seekBarDialogPreference = this.w0;
            if (seekBarDialogPreference.a(Integer.valueOf(Math.min(seekBarDialogPreference.c0, Math.max(seekBarDialogPreference.Z, i))))) {
                this.w0.L(i);
            }
        }
    }

    @Override // defpackage.dq0, android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.J0 = i;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        if (z) {
            int i2 = this.A0;
            int i3 = this.B0;
            int i4 = (i * i2) + i3;
            int i5 = i4 - (i4 % i2);
            if (i != 0) {
                i3 = i5;
            }
            if (i == seekBar.getMax()) {
                i3 = this.C0;
            }
            p0(i3);
            o0(i3);
        }
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        int iA;
        try {
            if (this.x0.hasFocus()) {
                int i4 = Integer.parseInt(charSequence.toString());
                if (this.B0 > i4 || i4 > this.C0) {
                    return;
                }
                q0(i4);
                o0(i4);
                if (this.I0) {
                    r0(this.y0, Math.round(i4 / (ey0.a.densityDpi / 160.0f)) + "");
                    return;
                }
                return;
            }
            if (!this.y0.hasFocus() || this.B0 > (iA = ey0.a(Integer.parseInt(charSequence.toString()))) || iA > this.C0) {
                return;
            }
            q0(iA);
            o0(iA);
            if (this.I0) {
                r0(this.x0, iA + "");
            }
        } catch (Exception unused) {
        }
    }

    public final void p0(int i) {
        r0(this.x0, i + "");
        if (this.I0) {
            r0(this.y0, Math.round(i / (ey0.a.densityDpi / 160.0f)) + "");
        }
    }

    public final void q0(int i) {
        int i2 = this.B0;
        int max = (i - i2) / this.A0;
        if (!this.G0) {
            max++;
        }
        if (i == i2) {
            max = 0;
        }
        if (i == this.C0) {
            max = this.z0.getMax();
        }
        this.z0.setProgress(max);
    }

    public final void r0(TextView textView, String str) {
        if (textView.getText().toString().equalsIgnoreCase(str)) {
            return;
        }
        textView.removeTextChangedListener(this);
        textView.setText(str);
        textView.addTextChangedListener(this);
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStopTrackingTouch(SeekBar seekBar) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
