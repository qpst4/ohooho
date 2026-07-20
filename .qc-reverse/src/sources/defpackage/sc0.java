package defpackage;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.quickcursor.android.views.settings.ActionsRecyclerView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class sc0 extends wt0 {
    public Rect A;
    public long B;
    public float d;
    public float e;
    public float f;
    public float g;
    public float h;
    public float i;
    public float j;
    public float k;
    public final t3 m;
    public int o;
    public int q;
    public ActionsRecyclerView r;
    public VelocityTracker t;
    public ArrayList u;
    public ArrayList v;
    public sp1 x;
    public rc0 y;
    public final ArrayList a = new ArrayList();
    public final float[] b = new float[2];
    public pu0 c = null;
    public int l = -1;
    public int n = 0;
    public final ArrayList p = new ArrayList();
    public final nc s = new nc(9, this);
    public View w = null;
    public final oc0 z = new oc0(this);

    public sc0(t3 t3Var) {
        this.m = t3Var;
    }

    public static boolean m(View view, float f, float f2, float f3, float f4) {
        return f >= f3 && f <= f3 + ((float) view.getWidth()) && f2 >= f4 && f2 <= f4 + ((float) view.getHeight());
    }

    @Override // defpackage.wt0
    public final void d(Rect rect, View view, RecyclerView recyclerView) {
        rect.setEmpty();
    }

    @Override // defpackage.wt0
    public final void e(Canvas canvas, RecyclerView recyclerView) {
        float f;
        float f2;
        if (this.c != null) {
            float[] fArr = this.b;
            l(fArr);
            f = fArr[0];
            f2 = fArr[1];
        } else {
            f = 0.0f;
            f2 = 0.0f;
        }
        pu0 pu0Var = this.c;
        this.m.getClass();
        ArrayList arrayList = this.p;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            pc0 pc0Var = (pc0) arrayList.get(i);
            pu0 pu0Var2 = pc0Var.e;
            float f3 = pc0Var.a;
            float f4 = pc0Var.c;
            if (f3 == f4) {
                pc0Var.i = pu0Var2.a.getTranslationX();
            } else {
                pc0Var.i = ((f4 - f3) * pc0Var.m) + f3;
            }
            float f5 = pc0Var.b;
            float f6 = pc0Var.d;
            if (f5 == f6) {
                pc0Var.j = pu0Var2.a.getTranslationY();
            } else {
                pc0Var.j = ((f6 - f5) * pc0Var.m) + f5;
            }
            int iSave = canvas.save();
            t3.e(recyclerView, pc0Var.e, pc0Var.i, pc0Var.j, false);
            canvas.restoreToCount(iSave);
        }
        if (pu0Var != null) {
            int iSave2 = canvas.save();
            t3.e(recyclerView, pu0Var, f, f2, true);
            canvas.restoreToCount(iSave2);
        }
    }

    @Override // defpackage.wt0
    public final void f(Canvas canvas, RecyclerView recyclerView) {
        boolean z = false;
        if (this.c != null) {
            float[] fArr = this.b;
            l(fArr);
            float f = fArr[0];
            float f2 = fArr[1];
        }
        pu0 pu0Var = this.c;
        this.m.getClass();
        ArrayList arrayList = this.p;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            pc0 pc0Var = (pc0) arrayList.get(i);
            int iSave = canvas.save();
            View view = pc0Var.e.a;
            canvas.restoreToCount(iSave);
        }
        if (pu0Var != null) {
            canvas.restoreToCount(canvas.save());
        }
        for (int i2 = size - 1; i2 >= 0; i2--) {
            pc0 pc0Var2 = (pc0) arrayList.get(i2);
            boolean z2 = pc0Var2.l;
            if (z2 && !pc0Var2.h) {
                arrayList.remove(i2);
            } else if (!z2) {
                z = true;
            }
        }
        if (z) {
            recyclerView.invalidate();
        }
    }

    public final int g(int i) {
        if ((i & 12) == 0) {
            return 0;
        }
        int i2 = this.h > 0.0f ? 8 : 4;
        VelocityTracker velocityTracker = this.t;
        t3 t3Var = this.m;
        if (velocityTracker != null && this.l > -1) {
            float f = this.g;
            t3Var.getClass();
            velocityTracker.computeCurrentVelocity(1000, f);
            float xVelocity = this.t.getXVelocity(this.l);
            float yVelocity = this.t.getYVelocity(this.l);
            int i3 = xVelocity > 0.0f ? 8 : 4;
            float fAbs = Math.abs(xVelocity);
            if ((i3 & i) != 0 && i2 == i3 && fAbs >= this.f && fAbs > Math.abs(yVelocity)) {
                return i3;
            }
        }
        float width = this.r.getWidth();
        t3Var.getClass();
        float f2 = width * 0.5f;
        if ((i & i2) == 0 || Math.abs(this.h) <= f2) {
            return 0;
        }
        return i2;
    }

    public final void h(int i, int i2, MotionEvent motionEvent) {
        View viewK;
        if (this.c == null && i == 2 && this.n != 2) {
            this.m.getClass();
            if (this.r.getScrollState() == 1) {
                return;
            }
            zt0 layoutManager = this.r.getLayoutManager();
            int i3 = this.l;
            pu0 pu0VarI = null;
            if (i3 != -1) {
                int iFindPointerIndex = motionEvent.findPointerIndex(i3);
                float x = motionEvent.getX(iFindPointerIndex) - this.d;
                float y = motionEvent.getY(iFindPointerIndex) - this.e;
                float fAbs = Math.abs(x);
                float fAbs2 = Math.abs(y);
                float f = this.q;
                if ((fAbs >= f || fAbs2 >= f) && ((fAbs <= fAbs2 || !layoutManager.d()) && ((fAbs2 <= fAbs || !layoutManager.e()) && (viewK = k(motionEvent)) != null))) {
                    pu0VarI = this.r.I(viewK);
                }
            }
            if (pu0VarI == null) {
                return;
            }
            ActionsRecyclerView actionsRecyclerView = this.r;
            WeakHashMap weakHashMap = uf1.a;
            int iB = (t3.b(208947, actionsRecyclerView.getLayoutDirection()) & 65280) >> 8;
            if (iB == 0) {
                return;
            }
            float x2 = motionEvent.getX(i2);
            float y2 = motionEvent.getY(i2);
            float f2 = x2 - this.d;
            float f3 = y2 - this.e;
            float fAbs3 = Math.abs(f2);
            float fAbs4 = Math.abs(f3);
            float f4 = this.q;
            if (fAbs3 >= f4 || fAbs4 >= f4) {
                if (fAbs3 > fAbs4) {
                    if (f2 < 0.0f && (iB & 4) == 0) {
                        return;
                    }
                    if (f2 > 0.0f && (iB & 8) == 0) {
                        return;
                    }
                } else {
                    if (f3 < 0.0f && (iB & 1) == 0) {
                        return;
                    }
                    if (f3 > 0.0f && (iB & 2) == 0) {
                        return;
                    }
                }
                this.i = 0.0f;
                this.h = 0.0f;
                this.l = motionEvent.getPointerId(0);
                o(pu0VarI, 1);
            }
        }
    }

    public final int i(int i) {
        if ((i & 3) == 0) {
            return 0;
        }
        int i2 = this.i > 0.0f ? 2 : 1;
        VelocityTracker velocityTracker = this.t;
        t3 t3Var = this.m;
        if (velocityTracker != null && this.l > -1) {
            float f = this.g;
            t3Var.getClass();
            velocityTracker.computeCurrentVelocity(1000, f);
            float xVelocity = this.t.getXVelocity(this.l);
            float yVelocity = this.t.getYVelocity(this.l);
            int i3 = yVelocity > 0.0f ? 2 : 1;
            float fAbs = Math.abs(yVelocity);
            if ((i3 & i) != 0 && i3 == i2 && fAbs >= this.f && fAbs > Math.abs(xVelocity)) {
                return i3;
            }
        }
        float height = this.r.getHeight();
        t3Var.getClass();
        float f2 = height * 0.5f;
        if ((i & i2) == 0 || Math.abs(this.i) <= f2) {
            return 0;
        }
        return i2;
    }

    public final void j(pu0 pu0Var, boolean z) {
        ArrayList arrayList = this.p;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            pc0 pc0Var = (pc0) arrayList.get(size);
            if (pc0Var.e == pu0Var) {
                pc0Var.k |= z;
                if (!pc0Var.l) {
                    pc0Var.g.cancel();
                }
                arrayList.remove(size);
                return;
            }
        }
    }

    public final View k(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        pu0 pu0Var = this.c;
        if (pu0Var != null) {
            View view = pu0Var.a;
            if (m(view, x, y, this.j + this.h, this.k + this.i)) {
                return view;
            }
        }
        ArrayList arrayList = this.p;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            pc0 pc0Var = (pc0) arrayList.get(size);
            View view2 = pc0Var.e.a;
            if (m(view2, x, y, pc0Var.i, pc0Var.j)) {
                return view2;
            }
        }
        ActionsRecyclerView actionsRecyclerView = this.r;
        for (int iW = actionsRecyclerView.f.w() - 1; iW >= 0; iW--) {
            View viewV = actionsRecyclerView.f.v(iW);
            float translationX = viewV.getTranslationX();
            float translationY = viewV.getTranslationY();
            if (x >= viewV.getLeft() + translationX && x <= viewV.getRight() + translationX && y >= viewV.getTop() + translationY && y <= viewV.getBottom() + translationY) {
                return viewV;
            }
        }
        return null;
    }

    public final void l(float[] fArr) {
        if ((this.o & 12) != 0) {
            fArr[0] = (this.j + this.h) - this.c.a.getLeft();
        } else {
            fArr[0] = this.c.a.getTranslationX();
        }
        if ((this.o & 3) != 0) {
            fArr[1] = (this.k + this.i) - this.c.a.getTop();
        } else {
            fArr[1] = this.c.a.getTranslationY();
        }
    }

    public final void n(pu0 pu0Var) {
        int bottom;
        int iAbs;
        int top;
        int iAbs2;
        int left;
        int iAbs3;
        int right;
        int iAbs4;
        int i;
        int i2;
        int i3;
        if (!this.r.isLayoutRequested() && this.n == 2) {
            t3 t3Var = this.m;
            t3Var.getClass();
            int i4 = (int) (this.j + this.h);
            int i5 = (int) (this.k + this.i);
            View view = pu0Var.a;
            if (Math.abs(i5 - view.getTop()) >= view.getHeight() * 0.5f || Math.abs(i4 - view.getLeft()) >= view.getWidth() * 0.5f) {
                ArrayList arrayList = this.u;
                if (arrayList == null) {
                    this.u = new ArrayList();
                    this.v = new ArrayList();
                } else {
                    arrayList.clear();
                    this.v.clear();
                }
                int iRound = Math.round(this.j + this.h);
                int iRound2 = Math.round(this.k + this.i);
                int width = view.getWidth() + iRound;
                int height = view.getHeight() + iRound2;
                int i6 = (iRound + width) / 2;
                int i7 = (iRound2 + height) / 2;
                zt0 layoutManager = this.r.getLayoutManager();
                int iV = layoutManager.v();
                int i8 = 0;
                while (i8 < iV) {
                    View viewU = layoutManager.u(i8);
                    if (viewU == view) {
                        i = i8;
                    } else {
                        i = i8;
                        if (viewU.getBottom() >= iRound2 && viewU.getTop() <= height && viewU.getRight() >= iRound && viewU.getLeft() <= width) {
                            pu0 pu0VarI = this.r.I(viewU);
                            int iAbs5 = Math.abs(i6 - ((viewU.getRight() + viewU.getLeft()) / 2));
                            int iAbs6 = Math.abs(i7 - ((viewU.getBottom() + viewU.getTop()) / 2));
                            int i9 = (iAbs6 * iAbs6) + (iAbs5 * iAbs5);
                            i2 = i4;
                            int size = this.u.size();
                            i3 = i5;
                            int i10 = 0;
                            int i11 = 0;
                            while (i10 < size) {
                                int i12 = size;
                                if (i9 <= ((Integer) this.v.get(i10)).intValue()) {
                                    break;
                                }
                                i11++;
                                i10++;
                                size = i12;
                            }
                            this.u.add(i11, pu0VarI);
                            this.v.add(i11, Integer.valueOf(i9));
                        }
                        i8 = i + 1;
                        i4 = i2;
                        i5 = i3;
                    }
                    i2 = i4;
                    i3 = i5;
                    i8 = i + 1;
                    i4 = i2;
                    i5 = i3;
                }
                int i13 = i4;
                int i14 = i5;
                ArrayList arrayList2 = this.u;
                if (arrayList2.size() == 0) {
                    return;
                }
                int width2 = view.getWidth() + i13;
                int height2 = view.getHeight() + i14;
                int left2 = i13 - view.getLeft();
                int top2 = i14 - view.getTop();
                int size2 = arrayList2.size();
                pu0 pu0Var2 = null;
                int i15 = -1;
                for (int i16 = 0; i16 < size2; i16++) {
                    pu0 pu0Var3 = (pu0) arrayList2.get(i16);
                    if (left2 > 0 && (right = pu0Var3.a.getRight() - width2) < 0 && pu0Var3.a.getRight() > view.getRight() && (iAbs4 = Math.abs(right)) > i15) {
                        i15 = iAbs4;
                        pu0Var2 = pu0Var3;
                    }
                    if (left2 < 0 && (left = pu0Var3.a.getLeft() - i13) > 0 && pu0Var3.a.getLeft() < view.getLeft() && (iAbs3 = Math.abs(left)) > i15) {
                        i15 = iAbs3;
                        pu0Var2 = pu0Var3;
                    }
                    if (top2 < 0 && (top = pu0Var3.a.getTop() - i14) > 0 && pu0Var3.a.getTop() < view.getTop() && (iAbs2 = Math.abs(top)) > i15) {
                        i15 = iAbs2;
                        pu0Var2 = pu0Var3;
                    }
                    if (top2 > 0 && (bottom = pu0Var3.a.getBottom() - height2) < 0 && pu0Var3.a.getBottom() > view.getBottom() && (iAbs = Math.abs(bottom)) > i15) {
                        i15 = iAbs;
                        pu0Var2 = pu0Var3;
                    }
                }
                if (pu0Var2 == null) {
                    this.u.clear();
                    this.v.clear();
                    return;
                }
                View view2 = pu0Var2.a;
                int iB = pu0Var2.b();
                pu0Var.b();
                List list = (List) t3Var.b;
                int iB2 = pu0Var.b();
                int iB3 = pu0Var2.b();
                if (iB2 < iB3) {
                    int i17 = iB2;
                    while (i17 < iB3) {
                        int i18 = i17 + 1;
                        Collections.swap(list, i17, i18);
                        i17 = i18;
                    }
                } else {
                    for (int i19 = iB2; i19 > iB3; i19--) {
                        Collections.swap(list, i19, i19 - 1);
                    }
                }
                ((ActionsRecyclerView) t3Var.d).getAdapter().a.c(iB2, iB3);
                ((z3) t3Var.c).e();
                ActionsRecyclerView actionsRecyclerView = this.r;
                zt0 layoutManager2 = actionsRecyclerView.getLayoutManager();
                if (!(layoutManager2 instanceof LinearLayoutManager)) {
                    if (layoutManager2.d()) {
                        if (zt0.A(view2) <= actionsRecyclerView.getPaddingLeft()) {
                            actionsRecyclerView.d0(iB);
                        }
                        if (zt0.D(view2) >= actionsRecyclerView.getWidth() - actionsRecyclerView.getPaddingRight()) {
                            actionsRecyclerView.d0(iB);
                        }
                    }
                    if (layoutManager2.e()) {
                        if (zt0.E(view2) <= actionsRecyclerView.getPaddingTop()) {
                            actionsRecyclerView.d0(iB);
                        }
                        if (zt0.y(view2) >= actionsRecyclerView.getHeight() - actionsRecyclerView.getPaddingBottom()) {
                            actionsRecyclerView.d0(iB);
                            return;
                        }
                        return;
                    }
                    return;
                }
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager2;
                linearLayoutManager.c("Cannot drop a view during a scroll or layout calculation");
                linearLayoutManager.K0();
                linearLayoutManager.b1();
                int iL = zt0.L(view);
                int iL2 = zt0.L(view2);
                byte b = iL < iL2 ? (byte) 1 : (byte) -1;
                boolean z = linearLayoutManager.u;
                px pxVar = linearLayoutManager.r;
                if (z) {
                    if (b == 1) {
                        linearLayoutManager.d1(iL2, pxVar.g() - (linearLayoutManager.r.c(view) + linearLayoutManager.r.e(view2)));
                        return;
                    } else {
                        linearLayoutManager.d1(iL2, pxVar.g() - linearLayoutManager.r.b(view2));
                        return;
                    }
                }
                if (b == -1) {
                    linearLayoutManager.d1(iL2, pxVar.e(view2));
                } else {
                    linearLayoutManager.d1(iL2, pxVar.b(view2) - linearLayoutManager.r.c(view));
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0132  */
    /* JADX WARN: Type inference failed for: r0v6, types: [android.view.ViewParent] */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v10 */
    /* JADX WARN: Type inference failed for: r12v11 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r12v7, types: [boolean] */
    /* JADX WARN: Type inference failed for: r12v9 */
    /* JADX WARN: Type inference failed for: r2v1, types: [pu0] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void o(defpackage.pu0 r22, int r23) {
        /*
            Method dump skipped, instruction units count: 445
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.sc0.o(pu0, int):void");
    }

    public final void p(int i, int i2, MotionEvent motionEvent) {
        float x = motionEvent.getX(i2);
        float y = motionEvent.getY(i2);
        float f = x - this.d;
        this.h = f;
        this.i = y - this.e;
        if ((i & 4) == 0) {
            this.h = Math.max(0.0f, f);
        }
        if ((i & 8) == 0) {
            this.h = Math.min(0.0f, this.h);
        }
        if ((i & 1) == 0) {
            this.i = Math.max(0.0f, this.i);
        }
        if ((i & 2) == 0) {
            this.i = Math.min(0.0f, this.i);
        }
    }
}
