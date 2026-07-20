package defpackage;

import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class hs implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ ArrayList c;
    public final /* synthetic */ ns d;

    public /* synthetic */ hs(ns nsVar, ArrayList arrayList, int i) {
        this.b = i;
        this.d = nsVar;
        this.c = arrayList;
    }

    @Override // java.lang.Runnable
    public final void run() {
        char c;
        int i = this.b;
        int i2 = 0;
        ArrayList arrayList = this.c;
        switch (i) {
            case 0:
                int size = arrayList.size();
                while (true) {
                    ns nsVar = this.d;
                    if (i2 >= size) {
                        arrayList.clear();
                        nsVar.m.remove(arrayList);
                    } else {
                        Object obj = arrayList.get(i2);
                        i2++;
                        ms msVar = (ms) obj;
                        pu0 pu0Var = msVar.a;
                        int i3 = msVar.b;
                        int i4 = msVar.c;
                        int i5 = msVar.d;
                        int i6 = msVar.e;
                        nsVar.getClass();
                        View view = pu0Var.a;
                        int i7 = i5 - i3;
                        int i8 = i6 - i4;
                        if (i7 != 0) {
                            view.animate().translationX(0.0f);
                        }
                        if (i8 != 0) {
                            view.animate().translationY(0.0f);
                        }
                        ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
                        nsVar.p.add(pu0Var);
                        viewPropertyAnimatorAnimate.setDuration(nsVar.e).setListener(new js(nsVar, pu0Var, i7, view, i8, viewPropertyAnimatorAnimate)).start();
                    }
                    break;
                }
                break;
            case 1:
                int size2 = arrayList.size();
                while (true) {
                    ns nsVar2 = this.d;
                    if (i2 >= size2) {
                        arrayList.clear();
                        nsVar2.n.remove(arrayList);
                        break;
                    } else {
                        Object obj2 = arrayList.get(i2);
                        i2++;
                        ls lsVar = (ls) obj2;
                        ArrayList arrayList2 = nsVar2.r;
                        long j = nsVar2.f;
                        pu0 pu0Var2 = lsVar.a;
                        View view2 = pu0Var2 == null ? null : pu0Var2.a;
                        pu0 pu0Var3 = lsVar.b;
                        View view3 = pu0Var3 != null ? pu0Var3.a : null;
                        if (view2 != null) {
                            ViewPropertyAnimator duration = view2.animate().setDuration(j);
                            arrayList2.add(lsVar.a);
                            duration.translationX(lsVar.e - lsVar.c);
                            duration.translationY(lsVar.f - lsVar.d);
                            duration.alpha(0.0f).setListener(new ks(nsVar2, lsVar, duration, view2, 0)).start();
                        }
                        if (view3 != null) {
                            ViewPropertyAnimator viewPropertyAnimatorAnimate2 = view3.animate();
                            arrayList2.add(lsVar.b);
                            c = 0;
                            viewPropertyAnimatorAnimate2.translationX(0.0f).translationY(0.0f).setDuration(j).alpha(1.0f).setListener(new ks(nsVar2, lsVar, viewPropertyAnimatorAnimate2, view3, 1)).start();
                        } else {
                            c = 0;
                        }
                    }
                }
                break;
            default:
                int size3 = arrayList.size();
                while (true) {
                    ns nsVar3 = this.d;
                    if (i2 >= size3) {
                        arrayList.clear();
                        nsVar3.l.remove(arrayList);
                    } else {
                        Object obj3 = arrayList.get(i2);
                        i2++;
                        pu0 pu0Var4 = (pu0) obj3;
                        nsVar3.getClass();
                        View view4 = pu0Var4.a;
                        ViewPropertyAnimator viewPropertyAnimatorAnimate3 = view4.animate();
                        nsVar3.o.add(pu0Var4);
                        viewPropertyAnimatorAnimate3.alpha(1.0f).setDuration(nsVar3.c).setListener(new is(nsVar3, pu0Var4, view4, viewPropertyAnimatorAnimate3)).start();
                    }
                    break;
                }
                break;
        }
    }
}
