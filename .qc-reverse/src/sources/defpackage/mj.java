package defpackage;

import android.content.Context;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.quickcursor.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class mj extends qt0 {
    public final Context c;
    public final kj d;
    public List e;
    public final LayoutInflater f;

    public mj(Context context, kj kjVar, ArrayList arrayList) {
        this.c = context;
        this.d = kjVar;
        this.e = arrayList;
        this.f = LayoutInflater.from(context);
    }

    @Override // defpackage.qt0
    public final int a() {
        return this.e.size();
    }

    @Override // defpackage.qt0
    public final int c(int i) {
        return l11.r(h(i).b());
    }

    @Override // defpackage.qt0
    public final void e(pu0 pu0Var, int i) {
        int iB = h(i).b();
        Context context = this.c;
        kj kjVar = this.d;
        if (iB == 2) {
            rj rjVar = kjVar.d;
            mc0 mc0Var = (mc0) h(i);
            rjVar.getClass();
            oj ojVar = (oj) pu0Var;
            if (mc0Var != null) {
                String str = mc0Var.a;
                if (str == null) {
                    str = "";
                }
                String string = context.getString(R.string.changelog_version_title, str);
                TextView textView = ojVar.t;
                TextView textView2 = ojVar.u;
                textView.setText(string);
                String str2 = mc0Var.c;
                String str3 = str2 != null ? str2 : "";
                textView2.setText(str3);
                textView2.setVisibility(str3.length() > 0 ? 0 : 8);
                return;
            }
            return;
        }
        if (h(i).b() != 1) {
            if (h(i).b() == 3) {
                rj rjVar2 = kjVar.d;
                final lc0 lc0Var = (lc0) h(i);
                rjVar2.getClass();
                final pj pjVar = (pj) pu0Var;
                if (lc0Var != null) {
                    pjVar.t.setOnClickListener(new View.OnClickListener() { // from class: nj
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            mj mjVar = this;
                            rt0 rt0Var = mjVar.a;
                            int iB2 = pjVar.b();
                            ArrayList arrayList = lc0Var.a;
                            mjVar.e.remove(iB2);
                            if (arrayList.size() == 0) {
                                rt0Var.f(iB2, 1);
                                return;
                            }
                            mjVar.e.addAll(iB2, arrayList);
                            rt0Var.d(iB2, 1, null);
                            rt0Var.e(iB2 + 1, arrayList.size() - 1);
                        }
                    });
                    return;
                }
                return;
            }
            return;
        }
        rj rjVar3 = kjVar.d;
        nc0 nc0Var = (nc0) h(i);
        rjVar3.getClass();
        qj qjVar = (qj) pu0Var;
        TextView textView3 = qjVar.t;
        if (nc0Var != null) {
            String str4 = nc0Var.c;
            if (context != null) {
                switch (nc0Var.b.a) {
                    case 0:
                        str4 = context.getResources().getString(R.string.changelog_bug_prefix).replaceAll("\\[", "<").replaceAll("\\]", ">") + str4;
                        break;
                    case 1:
                        break;
                    default:
                        str4 = context.getResources().getString(R.string.changelog_bug_improvement).replaceAll("\\[", "<").replaceAll("\\]", ">") + str4;
                        break;
                }
            }
            textView3.setText(Html.fromHtml(str4));
            textView3.setMovementMethod(LinkMovementMethod.getInstance());
            qjVar.u.setVisibility(kjVar.c ? 0 : 8);
        }
    }

    @Override // defpackage.qt0
    public final pu0 f(ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = this.f;
        kj kjVar = this.d;
        if (i == 1) {
            kjVar.d.getClass();
            return new oj(layoutInflater.inflate(R.layout.changelog_header, viewGroup, false));
        }
        if (i == 0) {
            kjVar.d.getClass();
            return new qj(layoutInflater.inflate(R.layout.changelog_row, viewGroup, false));
        }
        if (i != 2) {
            throw new RuntimeException(qq0.i("Type not handled: ", i));
        }
        kjVar.d.getClass();
        return new pj(layoutInflater.inflate(R.layout.changelog_more, viewGroup, false));
    }

    public final la0 h(int i) {
        return (la0) this.e.get(i);
    }
}
