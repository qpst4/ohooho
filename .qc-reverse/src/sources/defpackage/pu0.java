package defpackage;

import android.util.Log;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class pu0 {
    public static final List s = Collections.EMPTY_LIST;
    public final View a;
    public WeakReference b;
    public int j;
    public RecyclerView r;
    public int c = -1;
    public int d = -1;
    public long e = -1;
    public int f = -1;
    public int g = -1;
    public pu0 h = null;
    public pu0 i = null;
    public ArrayList k = null;
    public List l = null;
    public int m = 0;
    public gu0 n = null;
    public boolean o = false;
    public int p = 0;
    public int q = -1;

    public pu0(View view) {
        if (view != null) {
            this.a = view;
        } else {
            zy.n("itemView may not be null");
            throw null;
        }
    }

    public final void a(int i) {
        this.j = i | this.j;
    }

    public final int b() {
        RecyclerView recyclerView = this.r;
        if (recyclerView == null) {
            return -1;
        }
        return recyclerView.G(this);
    }

    public final int c() {
        int i = this.g;
        return i == -1 ? this.c : i;
    }

    public final List d() {
        ArrayList arrayList;
        return ((this.j & 1024) != 0 || (arrayList = this.k) == null || arrayList.size() == 0) ? s : this.l;
    }

    public final boolean e() {
        View view = this.a;
        return (view.getParent() == null || view.getParent() == this.r) ? false : true;
    }

    public final boolean f() {
        return (this.j & 1) != 0;
    }

    public final boolean g() {
        return (this.j & 4) != 0;
    }

    public final boolean h() {
        if ((this.j & 16) != 0) {
            return false;
        }
        WeakHashMap weakHashMap = uf1.a;
        return !this.a.hasTransientState();
    }

    public final boolean i() {
        return (this.j & 8) != 0;
    }

    public final boolean j() {
        return this.n != null;
    }

    public final boolean k() {
        return (this.j & 256) != 0;
    }

    public final boolean l() {
        return (this.j & 2) != 0;
    }

    public final void m(int i, boolean z) {
        if (this.d == -1) {
            this.d = this.c;
        }
        if (this.g == -1) {
            this.g = this.c;
        }
        if (z) {
            this.g += i;
        }
        this.c += i;
        View view = this.a;
        if (view.getLayoutParams() != null) {
            ((au0) view.getLayoutParams()).c = true;
        }
    }

    public final void n() {
        this.j = 0;
        this.c = -1;
        this.d = -1;
        this.e = -1L;
        this.g = -1;
        this.m = 0;
        this.h = null;
        this.i = null;
        ArrayList arrayList = this.k;
        if (arrayList != null) {
            arrayList.clear();
        }
        this.j &= -1025;
        this.p = 0;
        this.q = -1;
        RecyclerView.j(this);
    }

    public final void o(boolean z) {
        int i = this.m;
        int i2 = z ? i - 1 : i + 1;
        this.m = i2;
        if (i2 < 0) {
            this.m = 0;
            Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
            return;
        }
        if (!z && i2 == 1) {
            this.j |= 16;
        } else if (z && i2 == 0) {
            this.j &= -17;
        }
    }

    public final boolean p() {
        return (this.j & 128) != 0;
    }

    public final boolean q() {
        return (this.j & 32) != 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder((getClass().isAnonymousClass() ? "ViewHolder" : getClass().getSimpleName()) + "{" + Integer.toHexString(hashCode()) + " position=" + this.c + " id=" + this.e + ", oldPos=" + this.d + ", pLpos:" + this.g);
        if (j()) {
            sb.append(" scrap ");
            sb.append(this.o ? "[changeScrap]" : "[attachedScrap]");
        }
        if (g()) {
            sb.append(" invalid");
        }
        if (!f()) {
            sb.append(" unbound");
        }
        if ((this.j & 2) != 0) {
            sb.append(" update");
        }
        if (i()) {
            sb.append(" removed");
        }
        if (p()) {
            sb.append(" ignored");
        }
        if (k()) {
            sb.append(" tmpDetached");
        }
        if (!h()) {
            sb.append(" not recyclable(" + this.m + ")");
        }
        if ((this.j & 512) != 0 || g()) {
            sb.append(" undefined adapter position");
        }
        if (this.a.getParent() == null) {
            sb.append(" no parent");
        }
        sb.append("}");
        return sb.toString();
    }
}
