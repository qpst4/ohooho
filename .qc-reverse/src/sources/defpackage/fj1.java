package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.quickcursor.R;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class fj1 extends qt0 {
    public final zj0 c;

    public fj1(zj0 zj0Var) {
        this.c = zj0Var;
    }

    @Override // defpackage.qt0
    public final int a() {
        return this.c.a0.g;
    }

    @Override // defpackage.qt0
    public final void e(pu0 pu0Var, int i) {
        zj0 zj0Var = this.c;
        int i2 = zj0Var.a0.b.d + i;
        TextView textView = ((ej1) pu0Var).t;
        textView.setText(String.format(Locale.getDefault(), "%d", Integer.valueOf(i2)));
        Context context = textView.getContext();
        textView.setContentDescription(wd1.b().get(1) == i2 ? String.format(context.getString(R.string.mtrl_picker_navigate_to_current_year_description), Integer.valueOf(i2)) : String.format(context.getString(R.string.mtrl_picker_navigate_to_year_description), Integer.valueOf(i2)));
        i9 i9Var = zj0Var.d0;
        if (wd1.b().get(1) == i2) {
            Object obj = i9Var.d;
        } else {
            Object obj2 = i9Var.c;
        }
        throw null;
    }

    @Override // defpackage.qt0
    public final pu0 f(ViewGroup viewGroup, int i) {
        return new ej1((TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_year, viewGroup, false));
    }
}
