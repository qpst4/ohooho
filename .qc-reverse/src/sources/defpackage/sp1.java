package defpackage;

import android.content.ClipData;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.ContentInfo;
import android.view.GestureDetector;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.gms.common.internal.a;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class sp1 implements ol0, xk0, ga, ie, bl0, co, fo, un0, z00, l81, dg1 {
    public static final hm1 d = new hm1();
    public static sp1 e;
    public final /* synthetic */ int b;
    public Object c;

    public sp1(int i) {
        this.b = i;
        switch (i) {
            case 1:
                if (Build.VERSION.SDK_INT < 26) {
                    this.c = new o0(this);
                } else {
                    this.c = new p0(this);
                }
                break;
            case 5:
                break;
            case 10:
                HashSet hashSet = new HashSet();
                this.c = hashSet;
                hashSet.add(new sj(1));
                hashSet.add(new sj(2));
                hashSet.add(new sj(0));
                break;
            default:
                aq1 aq1Var = aq1.c;
                tb0 tb0Var = new tb0(28, new vp1[]{ow0.i, d});
                Charset charset = lp1.a;
                this.c = tb0Var;
                break;
        }
    }

    public static void x(Context context, ArrayList arrayList) {
        StringBuilder sb = new StringBuilder("Denied:");
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            sb.append(" ");
            sb.append((String) obj);
        }
        fc0.A(sb.toString());
        Toast.makeText(context, "Permission Denied.", 0).show();
    }

    @Override // defpackage.ol0
    public void a(zk0 zk0Var, boolean z) {
        if (zk0Var instanceof g31) {
            ((g31) zk0Var).z.k().c(false);
        }
        ol0 ol0Var = ((a2) this.c).f;
        if (ol0Var != null) {
            ol0Var.a(zk0Var, z);
        }
    }

    @Override // defpackage.co
    public go build() {
        return new go(new sp1(((ContentInfo.Builder) this.c).build()));
    }

    @Override // defpackage.fo
    public ClipData c() {
        return ((ContentInfo) this.c).getClip();
    }

    @Override // defpackage.xk0
    public boolean e(zk0 zk0Var, MenuItem menuItem) {
        boolean zOnMenuItemSelected;
        d2 d2Var = ((ActionMenuView) this.c).B;
        if (d2Var != null) {
            Toolbar toolbar = ((s61) d2Var).b;
            Iterator it = ((CopyOnWriteArrayList) toolbar.H.e).iterator();
            while (true) {
                if (!it.hasNext()) {
                    w61 w61Var = toolbar.J;
                    zOnMenuItemSelected = w61Var != null ? ((y61) w61Var).b.b.onMenuItemSelected(0, menuItem) : false;
                } else if (((s30) it.next()).a.p()) {
                    zOnMenuItemSelected = true;
                    break;
                }
            }
            if (zOnMenuItemSelected) {
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.bl0
    public void f(zk0 zk0Var, MenuItem menuItem) {
        ((vi) this.c).g.removeCallbacksAndMessages(zk0Var);
    }

    @Override // defpackage.ie
    public void g(xm xmVar) {
        boolean z = xmVar.c == 0;
        a aVar = (a) this.c;
        if (z) {
            aVar.k(null, aVar.w);
            return;
        }
        tb0 tb0Var = aVar.o;
        if (tb0Var != null) {
            ((z60) tb0Var.c).b(xmVar);
        }
    }

    @Override // defpackage.wr0
    public Object get() {
        return new ra((Context) ((m0) this.c).b, new ix(29), new c70(28), 7, false);
    }

    @Override // defpackage.dg1
    public bg1 h(Class cls, jm0 jm0Var) {
        nx0 nx0Var = null;
        for (cg1 cg1Var : (cg1[]) this.c) {
            if (cg1Var.a.equals(cls)) {
                nx0Var = new nx0();
            }
        }
        if (nx0Var != null) {
            return nx0Var;
        }
        zy.n("No initializer set for given class ".concat(cls.getName()));
        return null;
    }

    @Override // defpackage.bl0
    public void i(zk0 zk0Var, cl0 cl0Var) {
        vi viVar = (vi) this.c;
        Handler handler = viVar.g;
        handler.removeCallbacksAndMessages(null);
        ArrayList arrayList = viVar.i;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                i = -1;
                break;
            } else if (zk0Var == ((ui) arrayList.get(i)).b) {
                break;
            } else {
                i++;
            }
        }
        if (i == -1) {
            return;
        }
        int i2 = i + 1;
        handler.postAtTime(new ti(this, i2 < arrayList.size() ? (ui) arrayList.get(i2) : null, cl0Var, zk0Var), zk0Var, SystemClock.uptimeMillis() + 200);
    }

    @Override // defpackage.l81
    public void j(j81 j81Var) {
        if (j81Var.d > 6) {
            si0.b("onInputDispatcherBugDetected cancelled. Couldn't fix the issue with 6 multi taps.");
        } else {
            l60.c(j81Var);
            b61.b(new k2(this, 10, j81Var), 10L);
        }
    }

    @Override // defpackage.un0
    public wi1 k(View view, wi1 wi1Var) {
        ri1 ri1Var = wi1Var.a;
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.c;
        if (!Objects.equals(coordinatorLayout.o, wi1Var)) {
            coordinatorLayout.o = wi1Var;
            boolean z = wi1Var.d() > 0;
            coordinatorLayout.p = z;
            coordinatorLayout.setWillNotDraw(!z && coordinatorLayout.getBackground() == null);
            if (!ri1Var.m()) {
                int childCount = coordinatorLayout.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = coordinatorLayout.getChildAt(i);
                    WeakHashMap weakHashMap = uf1.a;
                    if (childAt.getFitsSystemWindows() && ((qo) childAt.getLayoutParams()).a != null && ri1Var.m()) {
                        break;
                    }
                }
            }
            coordinatorLayout.requestLayout();
        }
        return wi1Var;
    }

    @Override // defpackage.fo
    public int l() {
        return ((ContentInfo) this.c).getFlags();
    }

    @Override // defpackage.fo
    public ContentInfo m() {
        return (ContentInfo) this.c;
    }

    @Override // defpackage.xk0
    public void n(zk0 zk0Var) {
        xk0 xk0Var = ((ActionMenuView) this.c).w;
        if (xk0Var != null) {
            xk0Var.n(zk0Var);
        }
    }

    @Override // defpackage.co
    public void p(Uri uri) {
        ((ContentInfo.Builder) this.c).setLinkUri(uri);
    }

    @Override // defpackage.fo
    public int q() {
        return ((ContentInfo) this.c).getSource();
    }

    @Override // defpackage.ol0
    public boolean s(zk0 zk0Var) {
        a2 a2Var = (a2) this.c;
        if (zk0Var == a2Var.d) {
            return false;
        }
        ((g31) zk0Var).A.getClass();
        ol0 ol0Var = a2Var.f;
        if (ol0Var != null) {
            return ol0Var.s(zk0Var);
        }
        return false;
    }

    @Override // defpackage.co
    public void setExtras(Bundle bundle) {
        ((ContentInfo.Builder) this.c).setExtras(bundle);
    }

    @Override // defpackage.co
    public void t(int i) {
        ((ContentInfo.Builder) this.c).setFlags(i);
    }

    public String toString() {
        switch (this.b) {
            case 13:
                return "ContentInfoCompat{" + ((ContentInfo) this.c) + "}";
            default:
                return super.toString();
        }
    }

    public n0 u(int i) {
        return null;
    }

    public n0 v(int i) {
        return null;
    }

    public void w() {
        ((l30) this.c).p.O();
    }

    public boolean y(int i, int i2, Bundle bundle) {
        return false;
    }

    public void d(int i) {
    }

    public void o(int i) {
    }

    public /* synthetic */ sp1(int i, Object obj) {
        this.b = i;
        this.c = obj;
    }

    public sp1(int i, byte[] bArr) {
        this.b = 28;
        byte[] bArr2 = new byte[i];
        this.c = bArr2;
        System.arraycopy(bArr, 0, bArr2, 0, i);
    }

    public sp1(Context context, rc0 rc0Var) {
        this.b = 26;
        this.c = new GestureDetector(context, rc0Var, null);
    }

    public sp1(TextView textView) {
        this.b = 21;
        this.c = new ey(textView);
    }

    public sp1(EditText editText) {
        this.b = 20;
        this.c = new i9(editText, 14);
    }

    public void r(int i, float f) {
    }

    public sp1(ContentInfo contentInfo) {
        this.b = 13;
        contentInfo.getClass();
        this.c = dg.m(contentInfo);
    }

    public sp1(ClipData clipData, int i) {
        this.b = 12;
        this.c = dg.k(clipData, i);
    }
}
