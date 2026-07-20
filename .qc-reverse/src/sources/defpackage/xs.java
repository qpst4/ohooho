package defpackage;

import android.animation.Animator;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.fragment.app.a;
import com.quickcursor.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class xs {
    public final ViewGroup a;
    public final ArrayList b = new ArrayList();
    public final ArrayList c = new ArrayList();
    public boolean d = false;
    public boolean e = false;

    public xs(ViewGroup viewGroup) {
        this.a = viewGroup;
    }

    public static xs f(ViewGroup viewGroup, ix ixVar) {
        Object tag = viewGroup.getTag(R.id.special_effects_controller_view_tag);
        if (tag instanceof xs) {
            return (xs) tag;
        }
        ixVar.getClass();
        xs xsVar = new xs(viewGroup);
        viewGroup.setTag(R.id.special_effects_controller_view_tag, xsVar);
        return xsVar;
    }

    public final void a(int i, int i2, a aVar) {
        synchronized (this.b) {
            try {
                oi oiVar = new oi();
                v11 v11VarD = d(aVar.c);
                if (v11VarD != null) {
                    v11VarD.c(i, i2);
                    return;
                }
                v11 v11Var = new v11(i, i2, aVar, oiVar);
                this.b.add(v11Var);
                v11Var.d.add(new u11(this, v11Var, 0));
                v11Var.d.add(new u11(this, v11Var, 1));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b(ArrayList arrayList, boolean z) {
        boolean z2;
        int i;
        ViewGroup viewGroup;
        ArrayList arrayList2 = arrayList;
        boolean z3 = z;
        int size = arrayList2.size();
        v11 v11Var = null;
        v11 v11Var2 = null;
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList2.get(i2);
            i2++;
            v11 v11Var3 = (v11) obj;
            int iD = qq0.d(v11Var3.c.H);
            int iR = l11.r(v11Var3.a);
            if (iR != 0) {
                if (iR != 1) {
                    if (iR == 2 || iR == 3) {
                    }
                } else if (iD != 2) {
                    v11Var2 = v11Var3;
                }
            }
            if (iD == 2 && v11Var == null) {
                v11Var = v11Var3;
            }
        }
        if (y30.I(2)) {
            Log.v("FragmentManager", "Executing operations from " + v11Var + " to " + v11Var2);
        }
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList(arrayList2);
        j30 j30Var = ((v11) arrayList2.get(arrayList2.size() - 1)).c;
        int size2 = arrayList2.size();
        int i3 = 0;
        while (i3 < size2) {
            Object obj2 = arrayList2.get(i3);
            i3++;
            h30 h30Var = ((v11) obj2).c.K;
            h30 h30Var2 = j30Var.K;
            h30Var.b = h30Var2.b;
            h30Var.c = h30Var2.c;
            h30Var.d = h30Var2.d;
            h30Var.e = h30Var2.e;
        }
        int size3 = arrayList2.size();
        int i4 = 0;
        while (i4 < size3) {
            Object obj3 = arrayList2.get(i4);
            i4++;
            v11 v11Var4 = (v11) obj3;
            oi oiVar = new oi();
            v11Var4.d();
            HashSet hashSet = v11Var4.e;
            hashSet.add(oiVar);
            vs vsVar = new vs(v11Var4, oiVar);
            vsVar.d = false;
            vsVar.c = z3;
            arrayList3.add(vsVar);
            oi oiVar2 = new oi();
            v11Var4.d();
            hashSet.add(oiVar2);
            boolean z4 = !z3 ? v11Var4 != v11Var2 : v11Var4 != v11Var;
            ws wsVar = new ws(v11Var4, oiVar2);
            int i5 = v11Var4.a;
            j30 j30Var2 = v11Var4.c;
            if (i5 == 2) {
                if (z) {
                    h30 h30Var3 = j30Var2.K;
                } else {
                    j30Var2.getClass();
                }
                if (z) {
                    h30 h30Var4 = j30Var2.K;
                } else {
                    h30 h30Var5 = j30Var2.K;
                    if (h30Var5 != null) {
                        Boolean bool = h30Var5.j;
                    }
                }
            } else if (z) {
                h30 h30Var6 = j30Var2.K;
            } else {
                j30Var2.getClass();
            }
            if (z4) {
                if (z) {
                    h30 h30Var7 = j30Var2.K;
                } else {
                    j30Var2.getClass();
                }
            }
            arrayList4.add(wsVar);
            v11Var4.d.add(new vn1(this, arrayList5, v11Var4));
            arrayList2 = arrayList;
            z3 = z;
        }
        HashMap map = new HashMap();
        int size4 = arrayList4.size();
        int i6 = 0;
        while (i6 < size4) {
            Object obj4 = arrayList4.get(i6);
            i6++;
            v11 v11Var5 = (v11) ((ws) obj4).a;
            if (qq0.d(v11Var5.c.H) != v11Var5.a) {
            }
        }
        int size5 = arrayList4.size();
        int i7 = 0;
        while (i7 < size5) {
            Object obj5 = arrayList4.get(i7);
            i7++;
            ws wsVar2 = (ws) obj5;
            map.put((v11) wsVar2.a, Boolean.FALSE);
            wsVar2.d();
        }
        boolean zContainsValue = map.containsValue(Boolean.TRUE);
        ViewGroup viewGroup2 = this.a;
        Context context = viewGroup2.getContext();
        ArrayList arrayList6 = new ArrayList();
        int size6 = arrayList3.size();
        boolean z5 = false;
        int i8 = 0;
        while (i8 < size6) {
            Object obj6 = arrayList3.get(i8);
            int i9 = i8 + 1;
            vs vsVar2 = (vs) obj6;
            boolean z6 = zContainsValue;
            v11 v11Var6 = (v11) vsVar2.a;
            ArrayList arrayList7 = arrayList3;
            int iD2 = qq0.d(v11Var6.c.H);
            int i10 = v11Var6.a;
            int i11 = size6;
            if (iD2 == i10 || !(iD2 == 2 || i10 == 2)) {
                z2 = z5;
                i = i9;
                viewGroup = viewGroup2;
                vsVar2.d();
                size6 = i11;
                zContainsValue = z6;
                viewGroup2 = viewGroup;
                arrayList3 = arrayList7;
                i8 = i;
                z5 = z2;
            } else {
                i9 i9VarJ = vsVar2.j(context);
                if (i9VarJ == null) {
                    vsVar2.d();
                } else {
                    Animator animator = (Animator) i9VarJ.d;
                    if (animator == null) {
                        arrayList6.add(vsVar2);
                    } else {
                        v11 v11Var7 = (v11) vsVar2.a;
                        j30 j30Var3 = v11Var7.c;
                        z2 = z5;
                        i = i9;
                        if (Boolean.TRUE.equals(map.get(v11Var7))) {
                            if (y30.I(2)) {
                                Log.v("FragmentManager", "Ignoring Animator set on " + j30Var3 + " as this Fragment was involved in a Transition.");
                            }
                            vsVar2.d();
                            viewGroup = viewGroup2;
                            size6 = i11;
                            zContainsValue = z6;
                            viewGroup2 = viewGroup;
                            arrayList3 = arrayList7;
                            i8 = i;
                            z5 = z2;
                        } else {
                            boolean z7 = v11Var7.a == 3;
                            if (z7) {
                                arrayList5.remove(v11Var7);
                            }
                            View view = j30Var3.H;
                            viewGroup2.startViewTransition(view);
                            ViewGroup viewGroup3 = viewGroup2;
                            animator.addListener(new ts(viewGroup3, view, z7, v11Var7, vsVar2));
                            animator.setTarget(view);
                            animator.start();
                            if (y30.I(2)) {
                                Log.v("FragmentManager", "Animator from operation " + v11Var7 + " has started.");
                            }
                            ((oi) vsVar2.b).a(new i9(animator, v11Var7, 12, false));
                            size6 = i11;
                            zContainsValue = z6;
                            viewGroup2 = viewGroup3;
                            arrayList3 = arrayList7;
                            i8 = i;
                            z5 = true;
                        }
                    }
                }
                z2 = z5;
                i = i9;
                viewGroup = viewGroup2;
                size6 = i11;
                zContainsValue = z6;
                viewGroup2 = viewGroup;
                arrayList3 = arrayList7;
                i8 = i;
                z5 = z2;
            }
        }
        boolean z8 = zContainsValue;
        boolean z9 = z5;
        ViewGroup viewGroup4 = viewGroup2;
        int size7 = arrayList6.size();
        int i12 = 0;
        while (i12 < size7) {
            Object obj7 = arrayList6.get(i12);
            i12++;
            vs vsVar3 = (vs) obj7;
            v11 v11Var8 = (v11) vsVar3.a;
            j30 j30Var4 = v11Var8.c;
            if (z8) {
                if (y30.I(2)) {
                    Log.v("FragmentManager", "Ignoring Animation set on " + j30Var4 + " as Animations cannot run alongside Transitions.");
                }
                vsVar3.d();
            } else if (z9) {
                if (y30.I(2)) {
                    Log.v("FragmentManager", "Ignoring Animation set on " + j30Var4 + " as Animations cannot run alongside Animators.");
                }
                vsVar3.d();
            } else {
                View view2 = j30Var4.H;
                i9 i9VarJ2 = vsVar3.j(context);
                i9VarJ2.getClass();
                Animation animation = (Animation) i9VarJ2.c;
                animation.getClass();
                int i13 = size7;
                if (v11Var8.a != 1) {
                    view2.startAnimation(animation);
                    vsVar3.d();
                } else {
                    viewGroup4.startViewTransition(view2);
                    m30 m30Var = new m30(animation, viewGroup4, view2);
                    m30Var.setAnimationListener(new us(v11Var8, viewGroup4, view2, vsVar3));
                    view2.startAnimation(m30Var);
                    if (y30.I(2)) {
                        Log.v("FragmentManager", "Animation from operation " + v11Var8 + " has started.");
                    }
                }
                ((oi) vsVar3.b).a(new g7(view2, viewGroup4, vsVar3, v11Var8));
                size7 = i13;
            }
        }
        int size8 = arrayList5.size();
        int i14 = 0;
        while (i14 < size8) {
            Object obj8 = arrayList5.get(i14);
            i14++;
            v11 v11Var9 = (v11) obj8;
            qq0.a(v11Var9.c.H, v11Var9.a);
        }
        arrayList5.clear();
        if (y30.I(2)) {
            Log.v("FragmentManager", "Completed executing operations from " + v11Var + " to " + v11Var2);
        }
    }

    public final void c() {
        if (this.e) {
            return;
        }
        ViewGroup viewGroup = this.a;
        WeakHashMap weakHashMap = uf1.a;
        if (!viewGroup.isAttachedToWindow()) {
            e();
            this.d = false;
            return;
        }
        synchronized (this.b) {
            try {
                if (!this.b.isEmpty()) {
                    ArrayList arrayList = new ArrayList(this.c);
                    this.c.clear();
                    int size = arrayList.size();
                    int i = 0;
                    while (i < size) {
                        Object obj = arrayList.get(i);
                        i++;
                        v11 v11Var = (v11) obj;
                        if (y30.I(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Cancelling operation " + v11Var);
                        }
                        v11Var.a();
                        if (!v11Var.g) {
                            this.c.add(v11Var);
                        }
                    }
                    g();
                    ArrayList arrayList2 = new ArrayList(this.b);
                    this.b.clear();
                    this.c.addAll(arrayList2);
                    if (y30.I(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Executing pending operations");
                    }
                    int size2 = arrayList2.size();
                    int i2 = 0;
                    while (i2 < size2) {
                        Object obj2 = arrayList2.get(i2);
                        i2++;
                        ((v11) obj2).d();
                    }
                    b(arrayList2, this.d);
                    this.d = false;
                    if (y30.I(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Finished executing pending operations");
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final v11 d(j30 j30Var) {
        ArrayList arrayList = this.b;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            v11 v11Var = (v11) obj;
            j30 j30Var2 = v11Var.c;
            j30Var2.getClass();
            if (j30Var2 == j30Var && !v11Var.f) {
                return v11Var;
            }
        }
        return null;
    }

    public final void e() {
        String str;
        String str2;
        if (y30.I(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Forcing all operations to complete");
        }
        ViewGroup viewGroup = this.a;
        WeakHashMap weakHashMap = uf1.a;
        boolean zIsAttachedToWindow = viewGroup.isAttachedToWindow();
        synchronized (this.b) {
            try {
                g();
                ArrayList arrayList = this.b;
                int size = arrayList.size();
                int i = 0;
                int i2 = 0;
                while (i2 < size) {
                    Object obj = arrayList.get(i2);
                    i2++;
                    ((v11) obj).d();
                }
                ArrayList arrayList2 = new ArrayList(this.c);
                int size2 = arrayList2.size();
                int i3 = 0;
                while (i3 < size2) {
                    Object obj2 = arrayList2.get(i3);
                    i3++;
                    v11 v11Var = (v11) obj2;
                    if (y30.I(2)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("SpecialEffectsController: ");
                        if (zIsAttachedToWindow) {
                            str2 = "";
                        } else {
                            str2 = "Container " + this.a + " is not attached to window. ";
                        }
                        sb.append(str2);
                        sb.append("Cancelling running operation ");
                        sb.append(v11Var);
                        Log.v("FragmentManager", sb.toString());
                    }
                    v11Var.a();
                }
                ArrayList arrayList3 = new ArrayList(this.b);
                int size3 = arrayList3.size();
                while (i < size3) {
                    Object obj3 = arrayList3.get(i);
                    i++;
                    v11 v11Var2 = (v11) obj3;
                    if (y30.I(2)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("SpecialEffectsController: ");
                        if (zIsAttachedToWindow) {
                            str = "";
                        } else {
                            str = "Container " + this.a + " is not attached to window. ";
                        }
                        sb2.append(str);
                        sb2.append("Cancelling pending operation ");
                        sb2.append(v11Var2);
                        Log.v("FragmentManager", sb2.toString());
                    }
                    v11Var2.a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void g() {
        ArrayList arrayList = this.b;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            v11 v11Var = (v11) obj;
            if (v11Var.b == 2) {
                v11Var.c(qq0.c(v11Var.c.a0().getVisibility()), 1);
            }
        }
    }
}
