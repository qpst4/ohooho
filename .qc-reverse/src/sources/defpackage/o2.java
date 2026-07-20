package defpackage;

import android.text.Editable;
import android.text.TextWatcher;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class o2 implements TextWatcher {
    public final /* synthetic */ int b;
    public final /* synthetic */ wt c;

    public /* synthetic */ o2(wt wtVar, int i) {
        this.b = i;
        this.c = wtVar;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        int i = this.b;
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        int i4 = this.b;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        int i4 = this.b;
        wt wtVar = this.c;
        switch (i4) {
            case 0:
                r2 r2Var = (r2) wtVar;
                y2 y2Var = r2Var.r0;
                String lowerCase = r2Var.F0.getText().toString().toLowerCase();
                y2Var.getClass();
                String[] strArrSplit = lowerCase.split(" ");
                y2Var.e = new ArrayList();
                for (p2 p2Var : y2Var.d) {
                    boolean z = true;
                    for (String str : strArrSplit) {
                        z = z && (p2Var.c.contains(str) || p2Var.d.contains(str));
                    }
                    if (z) {
                        y2Var.e.add(p2Var);
                    }
                }
                y2Var.d();
                break;
            default:
                ya yaVar = (ya) wtVar;
                y2 y2Var2 = yaVar.r0;
                if (y2Var2 != null) {
                    y2Var2.h(yaVar.w0.getText().toString().toLowerCase());
                    break;
                }
                break;
        }
    }

    private final void a(Editable editable) {
    }

    private final void b(Editable editable) {
    }

    private final void c(int i, int i2, int i3, CharSequence charSequence) {
    }

    private final void d(int i, int i2, int i3, CharSequence charSequence) {
    }
}
