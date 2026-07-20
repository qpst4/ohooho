package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.quickcursor.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class lh0 extends qt0 {
    public final a3 c;
    public final List d;

    public lh0(ArrayList arrayList, a3 a3Var) {
        this.d = arrayList;
        this.c = a3Var;
    }

    @Override // defpackage.qt0
    public final int a() {
        return this.d.size();
    }

    @Override // defpackage.qt0
    public final void e(pu0 pu0Var, int i) {
        kh0 kh0Var = (kh0) pu0Var;
        jh0 jh0Var = (jh0) this.d.get(i);
        kh0Var.t.setText(jh0Var.a);
        TextView textView = kh0Var.u;
        String str = jh0Var.b;
        textView.setVisibility(str.isEmpty() ? 8 : 0);
        textView.setText(str);
        Integer num = jh0Var.c;
        ImageView imageView = kh0Var.v;
        if (num != null) {
            imageView.setImageResource(num.intValue());
        } else {
            imageView.setImageDrawable(null);
        }
        kh0Var.a.setTag(jh0Var);
    }

    @Override // defpackage.qt0
    public final pu0 f(ViewGroup viewGroup, int i) {
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_picker_recycler_item, viewGroup, false);
        viewInflate.setOnClickListener(this.c);
        return new kh0(viewInflate);
    }
}
