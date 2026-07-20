package defpackage;

import android.util.Log;
import com.quickcursor.R;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ld implements w30 {
    public final ArrayList a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public boolean g;
    public boolean h;
    public String i;
    public int j;
    public CharSequence k;
    public int l;
    public CharSequence m;
    public ArrayList n;
    public ArrayList o;
    public boolean p;
    public final y30 q;
    public boolean r;
    public int s;

    public ld(y30 y30Var) {
        y30Var.F();
        l30 l30Var = y30Var.t;
        if (l30Var != null) {
            l30Var.n.getClassLoader();
        }
        this.a = new ArrayList();
        this.h = true;
        this.p = false;
        this.s = -1;
        this.q = y30Var;
    }

    @Override // defpackage.w30
    public final boolean a(ArrayList arrayList, ArrayList arrayList2) {
        if (y30.I(2)) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (!this.g) {
            return true;
        }
        y30 y30Var = this.q;
        if (y30Var.d == null) {
            y30Var.d = new ArrayList();
        }
        y30Var.d.add(this);
        return true;
    }

    public final void b(h40 h40Var) {
        this.a.add(h40Var);
        h40Var.d = this.b;
        h40Var.e = this.c;
        h40Var.f = this.d;
        h40Var.g = this.e;
    }

    public final void c(String str) {
        if (!this.h) {
            s1.f("This FragmentTransaction is not allowed to be added to the back stack.");
        } else {
            this.g = true;
            this.i = str;
        }
    }

    public final void d(int i) {
        if (this.g) {
            if (y30.I(2)) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i);
            }
            ArrayList arrayList = this.a;
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                h40 h40Var = (h40) arrayList.get(i2);
                j30 j30Var = h40Var.b;
                if (j30Var != null) {
                    j30Var.s += i;
                    if (y30.I(2)) {
                        Log.v("FragmentManager", "Bump nesting of " + h40Var.b + " to " + h40Var.b.s);
                    }
                }
            }
        }
    }

    public final int e(boolean z) {
        if (this.r) {
            s1.f("commit already called");
            return 0;
        }
        if (y30.I(2)) {
            Log.v("FragmentManager", "Commit: " + this);
            PrintWriter printWriter = new PrintWriter(new ui0());
            h("  ", printWriter, true);
            printWriter.close();
        }
        this.r = true;
        boolean z2 = this.g;
        y30 y30Var = this.q;
        if (z2) {
            this.s = y30Var.i.getAndIncrement();
        } else {
            this.s = -1;
        }
        y30Var.x(this, z);
        return this.s;
    }

    public final void f(j30 j30Var) {
        y30 y30Var = j30Var.t;
        if (y30Var == null || y30Var == this.q) {
            b(new h40(6, j30Var));
            return;
        }
        throw new IllegalStateException("Cannot detach Fragment attached to a different FragmentManager. Fragment " + j30Var.toString() + " is already attached to a FragmentManager.");
    }

    public final void g(int i, j30 j30Var, String str, int i2) {
        String str2 = j30Var.O;
        if (str2 != null) {
            g40.c(j30Var, str2);
        }
        Class<?> cls = j30Var.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            s1.e(cls.getCanonicalName(), " must be a public static class to be  properly recreated from instance state.", "Fragment ");
            return;
        }
        if (str != null) {
            String str3 = j30Var.z;
            if (str3 != null && !str.equals(str3)) {
                StringBuilder sb = new StringBuilder("Can't change tag of fragment ");
                sb.append(j30Var);
                String str4 = j30Var.z;
                sb.append(": was ");
                sb.append(str4);
                sb.append(" now ");
                sb.append(str);
                throw new IllegalStateException(sb.toString());
            }
            j30Var.z = str;
        }
        if (i != 0) {
            if (i == -1) {
                throw new IllegalArgumentException("Can't add fragment " + j30Var + " with tag " + str + " to container view with no id");
            }
            int i3 = j30Var.x;
            if (i3 != 0 && i3 != i) {
                StringBuilder sb2 = new StringBuilder("Can't change container ID of fragment ");
                sb2.append(j30Var);
                int i4 = j30Var.x;
                sb2.append(": was ");
                sb2.append(i4);
                sb2.append(" now ");
                sb2.append(i);
                throw new IllegalStateException(sb2.toString());
            }
            j30Var.x = i;
            j30Var.y = i;
        }
        b(new h40(i2, j30Var));
        j30Var.t = this.q;
    }

    public final void h(String str, PrintWriter printWriter, boolean z) {
        String str2;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.i);
            printWriter.print(" mIndex=");
            printWriter.print(this.s);
            printWriter.print(" mCommitted=");
            printWriter.println(this.r);
            if (this.f != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f));
            }
            if (this.b != 0 || this.c != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.b));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.c));
            }
            if (this.d != 0 || this.e != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.d));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.e));
            }
            if (this.j != 0 || this.k != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.j));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.k);
            }
            if (this.l != 0 || this.m != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.l));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.m);
            }
        }
        ArrayList arrayList = this.a;
        if (arrayList.isEmpty()) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Operations:");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            h40 h40Var = (h40) arrayList.get(i);
            switch (h40Var.a) {
                case 0:
                    str2 = "NULL";
                    break;
                case 1:
                    str2 = "ADD";
                    break;
                case 2:
                    str2 = "REPLACE";
                    break;
                case 3:
                    str2 = "REMOVE";
                    break;
                case 4:
                    str2 = "HIDE";
                    break;
                case 5:
                    str2 = "SHOW";
                    break;
                case 6:
                    str2 = "DETACH";
                    break;
                case 7:
                    str2 = "ATTACH";
                    break;
                case 8:
                    str2 = "SET_PRIMARY_NAV";
                    break;
                case 9:
                    str2 = "UNSET_PRIMARY_NAV";
                    break;
                case 10:
                    str2 = "OP_SET_MAX_LIFECYCLE";
                    break;
                default:
                    str2 = "cmd=" + h40Var.a;
                    break;
            }
            printWriter.print(str);
            printWriter.print("  Op #");
            printWriter.print(i);
            printWriter.print(": ");
            printWriter.print(str2);
            printWriter.print(" ");
            printWriter.println(h40Var.b);
            if (z) {
                if (h40Var.d != 0 || h40Var.e != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(h40Var.d));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(h40Var.e));
                }
                if (h40Var.f != 0 || h40Var.g != 0) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(h40Var.f));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(h40Var.g));
                }
            }
        }
    }

    public final void i(int i, j30 j30Var) {
        if (i != 0) {
            g(i, j30Var, null, 2);
        } else {
            zy.n("Must use non-zero containerViewId");
        }
    }

    public final void j(int i, int i2) {
        this.b = R.anim.fragment_fade_in;
        this.c = R.anim.fragment_fade_out;
        this.d = i;
        this.e = i2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.s >= 0) {
            sb.append(" #");
            sb.append(this.s);
        }
        if (this.i != null) {
            sb.append(" ");
            sb.append(this.i);
        }
        sb.append("}");
        return sb.toString();
    }
}
