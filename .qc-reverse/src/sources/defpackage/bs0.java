package defpackage;

import android.app.Dialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.recyclerview.widget.RecyclerView;
import com.quickcursor.App;
import com.quickcursor.R;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class bs0 extends wt {
    public kj o0;
    public lj p0 = null;

    public static bs0 k0(kj kjVar) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("builder", kjVar);
        bs0 bs0Var = new bs0();
        if (y30.I(2)) {
            Log.d("FragmentManager", "Setting style and theme for DialogFragment " + bs0Var + " to 0, 2132017523");
        }
        bs0Var.c0 = 0;
        bs0Var.d0 = R.style.QCChangelogDialogDarkTheme;
        bs0Var.c0(bundle);
        return bs0Var;
    }

    @Override // defpackage.wt, defpackage.j30
    public final void J(Bundle bundle) {
        super.J(bundle);
        this.o0 = (kj) this.h.getParcelable("builder");
    }

    @Override // defpackage.j30
    public final void L() {
        lj ljVar = this.p0;
        if (ljVar != null) {
            ljVar.cancel(true);
        }
        this.F = true;
    }

    @Override // defpackage.wt
    public final Dialog i0() {
        String str;
        String string = this.o0.i;
        if (string == null) {
            Context contextU = u();
            Context contextU2 = u();
            try {
                str = contextU2.getPackageManager().getPackageInfo(contextU2.getPackageName(), 0).versionName;
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
                str = "";
            }
            string = contextU.getString(R.string.changelog_dialog_title, str);
        }
        kj kjVar = this.o0;
        String string2 = kjVar.j;
        String string3 = kjVar.k;
        if (string2 == null) {
            string2 = u().getString(R.string.changelog_dialog_button);
        }
        if (string3 == null) {
            string3 = u().getString(R.string.changelog_dialog_rate);
        }
        mj0 mj0Var = new mj0(t());
        x6 x6Var = (x6) mj0Var.c;
        x6Var.e = string;
        mj0Var.d = new ColorDrawable(App.c.getColor(R.color.colorPrimaryDark));
        mj0Var.q(string2, new g2(6));
        if (this.o0.f) {
            mj0Var.p(string3, new z2(11, this));
        }
        View viewInflate = t().getLayoutInflater().inflate(R.layout.changelog_dialog, (ViewGroup) null, false);
        lj ljVar = new lj(u(), (ProgressBar) viewInflate.findViewById(R.id.pbLoading), this.o0.b((RecyclerView) viewInflate.findViewById(R.id.rvChangelog)), this.o0);
        this.p0 = ljVar;
        ljVar.execute(new Void[0]);
        x6Var.u = viewInflate;
        return mj0Var.c();
    }
}
