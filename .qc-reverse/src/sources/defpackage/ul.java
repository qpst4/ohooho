package defpackage;

import android.text.InputFilter;
import android.widget.EditText;
import com.rarepebble.colorpicker.ColorPreference;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class ul extends dq0 {
    @Override // defpackage.dq0
    public final void n0(jl1 jl1Var) {
        ColorPreference colorPreference = (ColorPreference) k0();
        colorPreference.getClass();
        rl rlVar = new rl(colorPreference.b);
        Integer num = colorPreference.V;
        rlVar.setColor(colorPreference.f(num == null ? -7829368 : num.intValue()));
        boolean z = colorPreference.X;
        int i = 0;
        rlVar.b.setVisibility(z ? 0 : 8);
        InputFilter[] inputFilterArr = z ? e80.b : e80.a;
        EditText editText = rlVar.c;
        editText.setFilters(inputFilterArr);
        editText.setText(editText.getText());
        editText.setVisibility(colorPreference.Y ? 0 : 8);
        rlVar.e.setVisibility(colorPreference.Z ? 0 : 8);
        x6 x6Var = (x6) jl1Var.c;
        x6Var.e = null;
        x6Var.u = rlVar;
        jl1Var.l(colorPreference.R, new sl(colorPreference, rlVar));
        String str = colorPreference.U;
        if (str != null) {
            jl1Var.j(str, new tl(i, colorPreference));
        }
    }

    @Override // defpackage.dq0
    public final void m0(boolean z) {
    }
}
