package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import defpackage.i9;
import defpackage.in;
import defpackage.jn;
import defpackage.kn;
import defpackage.ln;
import defpackage.m70;
import defpackage.mn;
import defpackage.n70;
import defpackage.nn;
import defpackage.rg0;
import defpackage.rs0;
import defpackage.un;
import defpackage.vn;
import defpackage.wn;
import defpackage.xn;
import defpackage.yz0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class ConstraintLayout extends ViewGroup {
    public static yz0 q;
    public final SparseArray b;
    public final ArrayList c;
    public final wn d;
    public int e;
    public int f;
    public int g;
    public int h;
    public boolean i;
    public int j;
    public un k;
    public i9 l;
    public int m;
    public HashMap n;
    public final SparseArray o;
    public final ln p;

    public ConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = new SparseArray();
        this.c = new ArrayList(4);
        this.d = new wn();
        this.e = 0;
        this.f = 0;
        this.g = Integer.MAX_VALUE;
        this.h = Integer.MAX_VALUE;
        this.i = true;
        this.j = 257;
        this.k = null;
        this.l = null;
        this.m = -1;
        this.n = new HashMap();
        this.o = new SparseArray();
        this.p = new ln(this, this);
        i(attributeSet, 0);
    }

    public static kn g() {
        kn knVar = new kn(-2, -2);
        knVar.a = -1;
        knVar.b = -1;
        knVar.c = -1.0f;
        knVar.d = true;
        knVar.e = -1;
        knVar.f = -1;
        knVar.g = -1;
        knVar.h = -1;
        knVar.i = -1;
        knVar.j = -1;
        knVar.k = -1;
        knVar.l = -1;
        knVar.m = -1;
        knVar.n = -1;
        knVar.o = -1;
        knVar.p = -1;
        knVar.q = 0;
        knVar.r = 0.0f;
        knVar.s = -1;
        knVar.t = -1;
        knVar.u = -1;
        knVar.v = -1;
        knVar.w = Integer.MIN_VALUE;
        knVar.x = Integer.MIN_VALUE;
        knVar.y = Integer.MIN_VALUE;
        knVar.z = Integer.MIN_VALUE;
        knVar.A = Integer.MIN_VALUE;
        knVar.B = Integer.MIN_VALUE;
        knVar.C = Integer.MIN_VALUE;
        knVar.D = 0;
        knVar.E = 0.5f;
        knVar.F = 0.5f;
        knVar.G = null;
        knVar.H = -1.0f;
        knVar.I = -1.0f;
        knVar.J = 0;
        knVar.K = 0;
        knVar.L = 0;
        knVar.M = 0;
        knVar.N = 0;
        knVar.O = 0;
        knVar.P = 0;
        knVar.Q = 0;
        knVar.R = 1.0f;
        knVar.S = 1.0f;
        knVar.T = -1;
        knVar.U = -1;
        knVar.V = -1;
        knVar.W = false;
        knVar.X = false;
        knVar.Y = null;
        knVar.Z = 0;
        knVar.a0 = true;
        knVar.b0 = true;
        knVar.c0 = false;
        knVar.d0 = false;
        knVar.e0 = false;
        knVar.f0 = -1;
        knVar.g0 = -1;
        knVar.h0 = -1;
        knVar.i0 = -1;
        knVar.j0 = Integer.MIN_VALUE;
        knVar.k0 = Integer.MIN_VALUE;
        knVar.l0 = 0.5f;
        knVar.p0 = new vn();
        return knVar;
    }

    private int getPaddingWidth() {
        int iMax = Math.max(0, getPaddingRight()) + Math.max(0, getPaddingLeft());
        int iMax2 = Math.max(0, getPaddingEnd()) + Math.max(0, getPaddingStart());
        return iMax2 > 0 ? iMax2 : iMax;
    }

    public static yz0 getSharedValues() {
        if (q == null) {
            yz0 yz0Var = new yz0();
            new SparseIntArray();
            new HashMap();
            q = yz0Var;
        }
        return q;
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof kn;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        Object tag;
        int size;
        ArrayList arrayList = this.c;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            for (int i = 0; i < size; i++) {
                ((in) arrayList.get(i)).getClass();
            }
        }
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            float width = getWidth();
            float height = getHeight();
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt.getVisibility() != 8 && (tag = childAt.getTag()) != null && (tag instanceof String)) {
                    String[] strArrSplit = ((String) tag).split(",");
                    if (strArrSplit.length == 4) {
                        int i3 = Integer.parseInt(strArrSplit[0]);
                        int i4 = Integer.parseInt(strArrSplit[1]);
                        int i5 = Integer.parseInt(strArrSplit[2]);
                        int i6 = (int) ((i3 / 1080.0f) * width);
                        int i7 = (int) ((i4 / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(-65536);
                        float f = i6;
                        float f2 = i7;
                        float f3 = i6 + ((int) ((i5 / 1080.0f) * width));
                        canvas.drawLine(f, f2, f3, f2, paint);
                        float f4 = i7 + ((int) ((Integer.parseInt(strArrSplit[3]) / 1920.0f) * height));
                        canvas.drawLine(f3, f2, f3, f4, paint);
                        canvas.drawLine(f3, f4, f, f4, paint);
                        canvas.drawLine(f, f4, f, f2, paint);
                        paint.setColor(-16711936);
                        canvas.drawLine(f, f2, f3, f4, paint);
                        canvas.drawLine(f, f4, f3, f2, paint);
                    }
                }
            }
        }
    }

    @Override // android.view.View
    public final void forceLayout() {
        this.i = true;
        super.forceLayout();
    }

    @Override // android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return g();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        kn knVar = new kn(context, attributeSet);
        knVar.a = -1;
        knVar.b = -1;
        knVar.c = -1.0f;
        knVar.d = true;
        knVar.e = -1;
        knVar.f = -1;
        knVar.g = -1;
        knVar.h = -1;
        knVar.i = -1;
        knVar.j = -1;
        knVar.k = -1;
        knVar.l = -1;
        knVar.m = -1;
        knVar.n = -1;
        knVar.o = -1;
        knVar.p = -1;
        knVar.q = 0;
        knVar.r = 0.0f;
        knVar.s = -1;
        knVar.t = -1;
        knVar.u = -1;
        knVar.v = -1;
        knVar.w = Integer.MIN_VALUE;
        knVar.x = Integer.MIN_VALUE;
        knVar.y = Integer.MIN_VALUE;
        knVar.z = Integer.MIN_VALUE;
        knVar.A = Integer.MIN_VALUE;
        knVar.B = Integer.MIN_VALUE;
        knVar.C = Integer.MIN_VALUE;
        knVar.D = 0;
        knVar.E = 0.5f;
        knVar.F = 0.5f;
        knVar.G = null;
        knVar.H = -1.0f;
        knVar.I = -1.0f;
        knVar.J = 0;
        knVar.K = 0;
        knVar.L = 0;
        knVar.M = 0;
        knVar.N = 0;
        knVar.O = 0;
        knVar.P = 0;
        knVar.Q = 0;
        knVar.R = 1.0f;
        knVar.S = 1.0f;
        knVar.T = -1;
        knVar.U = -1;
        knVar.V = -1;
        knVar.W = false;
        knVar.X = false;
        knVar.Y = null;
        knVar.Z = 0;
        knVar.a0 = true;
        knVar.b0 = true;
        knVar.c0 = false;
        knVar.d0 = false;
        knVar.e0 = false;
        knVar.f0 = -1;
        knVar.g0 = -1;
        knVar.h0 = -1;
        knVar.i0 = -1;
        knVar.j0 = Integer.MIN_VALUE;
        knVar.k0 = Integer.MIN_VALUE;
        knVar.l0 = 0.5f;
        knVar.p0 = new vn();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, rs0.b);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i);
            int i2 = jn.a.get(index);
            switch (i2) {
                case 1:
                    knVar.V = typedArrayObtainStyledAttributes.getInt(index, knVar.V);
                    break;
                case 2:
                    int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, knVar.p);
                    knVar.p = resourceId;
                    if (resourceId == -1) {
                        knVar.p = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 3:
                    knVar.q = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, knVar.q);
                    break;
                case 4:
                    float f = typedArrayObtainStyledAttributes.getFloat(index, knVar.r) % 360.0f;
                    knVar.r = f;
                    if (f < 0.0f) {
                        knVar.r = (360.0f - f) % 360.0f;
                    }
                    break;
                case 5:
                    knVar.a = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, knVar.a);
                    break;
                case 6:
                    knVar.b = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, knVar.b);
                    break;
                case 7:
                    knVar.c = typedArrayObtainStyledAttributes.getFloat(index, knVar.c);
                    break;
                case 8:
                    int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, knVar.e);
                    knVar.e = resourceId2;
                    if (resourceId2 == -1) {
                        knVar.e = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 9:
                    int resourceId3 = typedArrayObtainStyledAttributes.getResourceId(index, knVar.f);
                    knVar.f = resourceId3;
                    if (resourceId3 == -1) {
                        knVar.f = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 10:
                    int resourceId4 = typedArrayObtainStyledAttributes.getResourceId(index, knVar.g);
                    knVar.g = resourceId4;
                    if (resourceId4 == -1) {
                        knVar.g = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 11:
                    int resourceId5 = typedArrayObtainStyledAttributes.getResourceId(index, knVar.h);
                    knVar.h = resourceId5;
                    if (resourceId5 == -1) {
                        knVar.h = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 12:
                    int resourceId6 = typedArrayObtainStyledAttributes.getResourceId(index, knVar.i);
                    knVar.i = resourceId6;
                    if (resourceId6 == -1) {
                        knVar.i = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 13:
                    int resourceId7 = typedArrayObtainStyledAttributes.getResourceId(index, knVar.j);
                    knVar.j = resourceId7;
                    if (resourceId7 == -1) {
                        knVar.j = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 14:
                    int resourceId8 = typedArrayObtainStyledAttributes.getResourceId(index, knVar.k);
                    knVar.k = resourceId8;
                    if (resourceId8 == -1) {
                        knVar.k = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 15:
                    int resourceId9 = typedArrayObtainStyledAttributes.getResourceId(index, knVar.l);
                    knVar.l = resourceId9;
                    if (resourceId9 == -1) {
                        knVar.l = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 16:
                    int resourceId10 = typedArrayObtainStyledAttributes.getResourceId(index, knVar.m);
                    knVar.m = resourceId10;
                    if (resourceId10 == -1) {
                        knVar.m = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 17:
                    int resourceId11 = typedArrayObtainStyledAttributes.getResourceId(index, knVar.s);
                    knVar.s = resourceId11;
                    if (resourceId11 == -1) {
                        knVar.s = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 18:
                    int resourceId12 = typedArrayObtainStyledAttributes.getResourceId(index, knVar.t);
                    knVar.t = resourceId12;
                    if (resourceId12 == -1) {
                        knVar.t = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 19:
                    int resourceId13 = typedArrayObtainStyledAttributes.getResourceId(index, knVar.u);
                    knVar.u = resourceId13;
                    if (resourceId13 == -1) {
                        knVar.u = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 20:
                    int resourceId14 = typedArrayObtainStyledAttributes.getResourceId(index, knVar.v);
                    knVar.v = resourceId14;
                    if (resourceId14 == -1) {
                        knVar.v = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 21:
                    knVar.w = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, knVar.w);
                    break;
                case 22:
                    knVar.x = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, knVar.x);
                    break;
                case 23:
                    knVar.y = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, knVar.y);
                    break;
                case 24:
                    knVar.z = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, knVar.z);
                    break;
                case 25:
                    knVar.A = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, knVar.A);
                    break;
                case 26:
                    knVar.B = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, knVar.B);
                    break;
                case 27:
                    knVar.W = typedArrayObtainStyledAttributes.getBoolean(index, knVar.W);
                    break;
                case 28:
                    knVar.X = typedArrayObtainStyledAttributes.getBoolean(index, knVar.X);
                    break;
                case 29:
                    knVar.E = typedArrayObtainStyledAttributes.getFloat(index, knVar.E);
                    break;
                case 30:
                    knVar.F = typedArrayObtainStyledAttributes.getFloat(index, knVar.F);
                    break;
                case 31:
                    int i3 = typedArrayObtainStyledAttributes.getInt(index, 0);
                    knVar.L = i3;
                    if (i3 == 1) {
                        Log.e("ConstraintLayout", "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
                    }
                    break;
                case 32:
                    int i4 = typedArrayObtainStyledAttributes.getInt(index, 0);
                    knVar.M = i4;
                    if (i4 == 1) {
                        Log.e("ConstraintLayout", "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
                    }
                    break;
                case 33:
                    try {
                        knVar.N = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, knVar.N);
                    } catch (Exception unused) {
                        if (typedArrayObtainStyledAttributes.getInt(index, knVar.N) == -2) {
                            knVar.N = -2;
                        }
                    }
                    break;
                case 34:
                    try {
                        knVar.P = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, knVar.P);
                    } catch (Exception unused2) {
                        if (typedArrayObtainStyledAttributes.getInt(index, knVar.P) == -2) {
                            knVar.P = -2;
                        }
                    }
                    break;
                case 35:
                    knVar.R = Math.max(0.0f, typedArrayObtainStyledAttributes.getFloat(index, knVar.R));
                    knVar.L = 2;
                    break;
                case 36:
                    try {
                        knVar.O = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, knVar.O);
                    } catch (Exception unused3) {
                        if (typedArrayObtainStyledAttributes.getInt(index, knVar.O) == -2) {
                            knVar.O = -2;
                        }
                    }
                    break;
                case 37:
                    try {
                        knVar.Q = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, knVar.Q);
                    } catch (Exception unused4) {
                        if (typedArrayObtainStyledAttributes.getInt(index, knVar.Q) == -2) {
                            knVar.Q = -2;
                        }
                    }
                    break;
                case 38:
                    knVar.S = Math.max(0.0f, typedArrayObtainStyledAttributes.getFloat(index, knVar.S));
                    knVar.M = 2;
                    break;
                default:
                    switch (i2) {
                        case 44:
                            un.h(knVar, typedArrayObtainStyledAttributes.getString(index));
                            break;
                        case 45:
                            knVar.H = typedArrayObtainStyledAttributes.getFloat(index, knVar.H);
                            break;
                        case 46:
                            knVar.I = typedArrayObtainStyledAttributes.getFloat(index, knVar.I);
                            break;
                        case 47:
                            knVar.J = typedArrayObtainStyledAttributes.getInt(index, 0);
                            break;
                        case 48:
                            knVar.K = typedArrayObtainStyledAttributes.getInt(index, 0);
                            break;
                        case 49:
                            knVar.T = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, knVar.T);
                            break;
                        case 50:
                            knVar.U = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, knVar.U);
                            break;
                        case 51:
                            knVar.Y = typedArrayObtainStyledAttributes.getString(index);
                            break;
                        case 52:
                            int resourceId15 = typedArrayObtainStyledAttributes.getResourceId(index, knVar.n);
                            knVar.n = resourceId15;
                            if (resourceId15 == -1) {
                                knVar.n = typedArrayObtainStyledAttributes.getInt(index, -1);
                            }
                            break;
                        case 53:
                            int resourceId16 = typedArrayObtainStyledAttributes.getResourceId(index, knVar.o);
                            knVar.o = resourceId16;
                            if (resourceId16 == -1) {
                                knVar.o = typedArrayObtainStyledAttributes.getInt(index, -1);
                            }
                            break;
                        case 54:
                            knVar.D = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, knVar.D);
                            break;
                        case 55:
                            knVar.C = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, knVar.C);
                            break;
                        default:
                            switch (i2) {
                                case 64:
                                    un.g(knVar, typedArrayObtainStyledAttributes, index, 0);
                                    break;
                                case 65:
                                    un.g(knVar, typedArrayObtainStyledAttributes, index, 1);
                                    break;
                                case 66:
                                    knVar.Z = typedArrayObtainStyledAttributes.getInt(index, knVar.Z);
                                    break;
                                case 67:
                                    knVar.d = typedArrayObtainStyledAttributes.getBoolean(index, knVar.d);
                                    break;
                            }
                            break;
                    }
                    break;
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        knVar.a();
        return knVar;
    }

    public int getMaxHeight() {
        return this.h;
    }

    public int getMaxWidth() {
        return this.g;
    }

    public int getMinHeight() {
        return this.f;
    }

    public int getMinWidth() {
        return this.e;
    }

    public int getOptimizationLevel() {
        return this.d.D0;
    }

    public String getSceneString() {
        int id;
        StringBuilder sb = new StringBuilder();
        wn wnVar = this.d;
        if (wnVar.j == null) {
            int id2 = getId();
            if (id2 != -1) {
                wnVar.j = getContext().getResources().getResourceEntryName(id2);
            } else {
                wnVar.j = "parent";
            }
        }
        if (wnVar.h0 == null) {
            wnVar.h0 = wnVar.j;
            Log.v("ConstraintLayout", " setDebugName " + wnVar.h0);
        }
        ArrayList arrayList = wnVar.q0;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            vn vnVar = (vn) obj;
            View view = vnVar.f0;
            if (view != null) {
                if (vnVar.j == null && (id = view.getId()) != -1) {
                    vnVar.j = getContext().getResources().getResourceEntryName(id);
                }
                if (vnVar.h0 == null) {
                    vnVar.h0 = vnVar.j;
                    Log.v("ConstraintLayout", " setDebugName " + vnVar.h0);
                }
            }
        }
        wnVar.n(sb);
        return sb.toString();
    }

    public final vn h(View view) {
        if (view == this) {
            return this.d;
        }
        if (view == null) {
            return null;
        }
        if (view.getLayoutParams() instanceof kn) {
            return ((kn) view.getLayoutParams()).p0;
        }
        view.setLayoutParams(generateLayoutParams(view.getLayoutParams()));
        if (view.getLayoutParams() instanceof kn) {
            return ((kn) view.getLayoutParams()).p0;
        }
        return null;
    }

    public final void i(AttributeSet attributeSet, int i) {
        wn wnVar = this.d;
        wnVar.f0 = this;
        ln lnVar = this.p;
        wnVar.u0 = lnVar;
        wnVar.s0.f = lnVar;
        this.b.put(getId(), this);
        this.k = null;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, rs0.b, i, 0);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i2);
                if (index == 16) {
                    this.e = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.e);
                } else if (index == 17) {
                    this.f = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f);
                } else if (index == 14) {
                    this.g = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.g);
                } else if (index == 15) {
                    this.h = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.h);
                } else if (index == 113) {
                    this.j = typedArrayObtainStyledAttributes.getInt(index, this.j);
                } else if (index == 56) {
                    int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, 0);
                    if (resourceId != 0) {
                        try {
                            j(resourceId);
                        } catch (Resources.NotFoundException unused) {
                            this.l = null;
                        }
                    }
                } else if (index == 34) {
                    int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, 0);
                    try {
                        un unVar = new un();
                        this.k = unVar;
                        unVar.e(getContext(), resourceId2);
                    } catch (Resources.NotFoundException unused2) {
                        this.k = null;
                    }
                    this.m = resourceId2;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        wnVar.D0 = this.j;
        rg0.q = wnVar.W(512);
    }

    public final void j(int i) {
        String str;
        Context context = getContext();
        i9 i9Var = new i9(10);
        i9Var.c = new SparseArray();
        i9Var.d = new SparseArray();
        XmlResourceParser xml = context.getResources().getXml(i);
        try {
            mn mnVar = null;
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 2) {
                    String name = xml.getName();
                    switch (name.hashCode()) {
                        case -1349929691:
                            if (name.equals("ConstraintSet")) {
                                i9Var.G(context, xml);
                            }
                            break;
                        case 80204913:
                            if (name.equals("State")) {
                                mn mnVar2 = new mn(context, xml);
                                ((SparseArray) i9Var.c).put(mnVar2.a, mnVar2);
                                mnVar = mnVar2;
                            }
                            break;
                        case 1382829617:
                            str = "StateSet";
                            name.equals(str);
                            break;
                        case 1657696882:
                            str = "layoutDescription";
                            name.equals(str);
                            break;
                        case 1901439077:
                            if (name.equals("Variant")) {
                                nn nnVar = new nn(context, xml);
                                if (mnVar != null) {
                                    ((ArrayList) mnVar.c).add(nnVar);
                                }
                            }
                            break;
                    }
                }
            }
        } catch (IOException e) {
            Log.e("ConstraintLayoutStates", "Error parsing resource: " + i, e);
        } catch (XmlPullParserException e2) {
            Log.e("ConstraintLayoutStates", "Error parsing resource: " + i, e2);
        }
        this.l = i9Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:160:0x030c  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x032b  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x034c  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0368  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k(defpackage.wn r28, int r29, int r30, int r31) {
        /*
            Method dump skipped, instruction units count: 1754
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.k(wn, int, int, int):void");
    }

    public final void l(vn vnVar, kn knVar, SparseArray sparseArray, int i, int i2) {
        View view = (View) this.b.get(i);
        vn vnVar2 = (vn) sparseArray.get(i);
        if (vnVar2 == null || view == null || !(view.getLayoutParams() instanceof kn)) {
            return;
        }
        knVar.c0 = true;
        if (i2 == 6) {
            kn knVar2 = (kn) view.getLayoutParams();
            knVar2.c0 = true;
            knVar2.p0.E = true;
        }
        vnVar.i(6).b(vnVar2.i(i2), knVar.D, knVar.C, true);
        vnVar.E = true;
        vnVar.i(3).j();
        vnVar.i(5).j();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        boolean zIsInEditMode = isInEditMode();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            kn knVar = (kn) childAt.getLayoutParams();
            vn vnVar = knVar.p0;
            if (childAt.getVisibility() != 8 || knVar.d0 || knVar.e0 || zIsInEditMode) {
                int iR = vnVar.r();
                int iS = vnVar.s();
                childAt.layout(iR, iS, vnVar.q() + iR, vnVar.k() + iS);
            }
        }
        ArrayList arrayList = this.c;
        int size = arrayList.size();
        if (size > 0) {
            for (int i6 = 0; i6 < size; i6++) {
                ((in) arrayList.get(i6)).getClass();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0334  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x034c  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x036a  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x038c  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x03b7  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x03d4  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x03f6  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0401  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x041f  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x0427  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x054c  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x0552  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMeasure(int r35, int r36) {
        /*
            Method dump skipped, instruction units count: 1559
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup
    public final void onViewAdded(View view) {
        super.onViewAdded(view);
        vn vnVarH = h(view);
        if ((view instanceof m70) && !(vnVarH instanceof n70)) {
            kn knVar = (kn) view.getLayoutParams();
            n70 n70Var = new n70();
            knVar.p0 = n70Var;
            knVar.d0 = true;
            n70Var.S(knVar.V);
        }
        if (view instanceof in) {
            in inVar = (in) view;
            inVar.i();
            ((kn) view.getLayoutParams()).e0 = true;
            ArrayList arrayList = this.c;
            if (!arrayList.contains(inVar)) {
                arrayList.add(inVar);
            }
        }
        this.b.put(view.getId(), view);
        this.i = true;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        this.b.remove(view.getId());
        vn vnVarH = h(view);
        this.d.q0.remove(vnVarH);
        vnVarH.C();
        this.c.remove(view);
        this.i = true;
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        this.i = true;
        super.requestLayout();
    }

    public void setConstraintSet(un unVar) {
        this.k = unVar;
    }

    @Override // android.view.View
    public void setId(int i) {
        int id = getId();
        SparseArray sparseArray = this.b;
        sparseArray.remove(id);
        super.setId(i);
        sparseArray.put(getId(), this);
    }

    public void setMaxHeight(int i) {
        if (i == this.h) {
            return;
        }
        this.h = i;
        requestLayout();
    }

    public void setMaxWidth(int i) {
        if (i == this.g) {
            return;
        }
        this.g = i;
        requestLayout();
    }

    public void setMinHeight(int i) {
        if (i == this.f) {
            return;
        }
        this.f = i;
        requestLayout();
    }

    public void setMinWidth(int i) {
        if (i == this.e) {
            return;
        }
        this.e = i;
        requestLayout();
    }

    public void setOnConstraintsChanged(xn xnVar) {
        i9 i9Var = this.l;
        if (i9Var != null) {
            i9Var.getClass();
        }
    }

    public void setOptimizationLevel(int i) {
        this.j = i;
        wn wnVar = this.d;
        wnVar.D0 = i;
        rg0.q = wnVar.W(512);
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = new SparseArray();
        this.c = new ArrayList(4);
        this.d = new wn();
        this.e = 0;
        this.f = 0;
        this.g = Integer.MAX_VALUE;
        this.h = Integer.MAX_VALUE;
        this.i = true;
        this.j = 257;
        this.k = null;
        this.l = null;
        this.m = -1;
        this.n = new HashMap();
        this.o = new SparseArray();
        this.p = new ln(this, this);
        i(attributeSet, i);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        kn knVar = new kn(layoutParams);
        knVar.a = -1;
        knVar.b = -1;
        knVar.c = -1.0f;
        knVar.d = true;
        knVar.e = -1;
        knVar.f = -1;
        knVar.g = -1;
        knVar.h = -1;
        knVar.i = -1;
        knVar.j = -1;
        knVar.k = -1;
        knVar.l = -1;
        knVar.m = -1;
        knVar.n = -1;
        knVar.o = -1;
        knVar.p = -1;
        knVar.q = 0;
        knVar.r = 0.0f;
        knVar.s = -1;
        knVar.t = -1;
        knVar.u = -1;
        knVar.v = -1;
        knVar.w = Integer.MIN_VALUE;
        knVar.x = Integer.MIN_VALUE;
        knVar.y = Integer.MIN_VALUE;
        knVar.z = Integer.MIN_VALUE;
        knVar.A = Integer.MIN_VALUE;
        knVar.B = Integer.MIN_VALUE;
        knVar.C = Integer.MIN_VALUE;
        knVar.D = 0;
        knVar.E = 0.5f;
        knVar.F = 0.5f;
        knVar.G = null;
        knVar.H = -1.0f;
        knVar.I = -1.0f;
        knVar.J = 0;
        knVar.K = 0;
        knVar.L = 0;
        knVar.M = 0;
        knVar.N = 0;
        knVar.O = 0;
        knVar.P = 0;
        knVar.Q = 0;
        knVar.R = 1.0f;
        knVar.S = 1.0f;
        knVar.T = -1;
        knVar.U = -1;
        knVar.V = -1;
        knVar.W = false;
        knVar.X = false;
        knVar.Y = null;
        knVar.Z = 0;
        knVar.a0 = true;
        knVar.b0 = true;
        knVar.c0 = false;
        knVar.d0 = false;
        knVar.e0 = false;
        knVar.f0 = -1;
        knVar.g0 = -1;
        knVar.h0 = -1;
        knVar.i0 = -1;
        knVar.j0 = Integer.MIN_VALUE;
        knVar.k0 = Integer.MIN_VALUE;
        knVar.l0 = 0.5f;
        knVar.p0 = new vn();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            ((ViewGroup.MarginLayoutParams) knVar).leftMargin = marginLayoutParams.leftMargin;
            ((ViewGroup.MarginLayoutParams) knVar).rightMargin = marginLayoutParams.rightMargin;
            ((ViewGroup.MarginLayoutParams) knVar).topMargin = marginLayoutParams.topMargin;
            ((ViewGroup.MarginLayoutParams) knVar).bottomMargin = marginLayoutParams.bottomMargin;
            knVar.setMarginStart(marginLayoutParams.getMarginStart());
            knVar.setMarginEnd(marginLayoutParams.getMarginEnd());
        }
        if (!(layoutParams instanceof kn)) {
            return knVar;
        }
        kn knVar2 = (kn) layoutParams;
        knVar.a = knVar2.a;
        knVar.b = knVar2.b;
        knVar.c = knVar2.c;
        knVar.d = knVar2.d;
        knVar.e = knVar2.e;
        knVar.f = knVar2.f;
        knVar.g = knVar2.g;
        knVar.h = knVar2.h;
        knVar.i = knVar2.i;
        knVar.j = knVar2.j;
        knVar.k = knVar2.k;
        knVar.l = knVar2.l;
        knVar.m = knVar2.m;
        knVar.n = knVar2.n;
        knVar.o = knVar2.o;
        knVar.p = knVar2.p;
        knVar.q = knVar2.q;
        knVar.r = knVar2.r;
        knVar.s = knVar2.s;
        knVar.t = knVar2.t;
        knVar.u = knVar2.u;
        knVar.v = knVar2.v;
        knVar.w = knVar2.w;
        knVar.x = knVar2.x;
        knVar.y = knVar2.y;
        knVar.z = knVar2.z;
        knVar.A = knVar2.A;
        knVar.B = knVar2.B;
        knVar.C = knVar2.C;
        knVar.D = knVar2.D;
        knVar.E = knVar2.E;
        knVar.F = knVar2.F;
        knVar.G = knVar2.G;
        knVar.H = knVar2.H;
        knVar.I = knVar2.I;
        knVar.J = knVar2.J;
        knVar.K = knVar2.K;
        knVar.W = knVar2.W;
        knVar.X = knVar2.X;
        knVar.L = knVar2.L;
        knVar.M = knVar2.M;
        knVar.N = knVar2.N;
        knVar.P = knVar2.P;
        knVar.O = knVar2.O;
        knVar.Q = knVar2.Q;
        knVar.R = knVar2.R;
        knVar.S = knVar2.S;
        knVar.T = knVar2.T;
        knVar.U = knVar2.U;
        knVar.V = knVar2.V;
        knVar.a0 = knVar2.a0;
        knVar.b0 = knVar2.b0;
        knVar.c0 = knVar2.c0;
        knVar.d0 = knVar2.d0;
        knVar.f0 = knVar2.f0;
        knVar.g0 = knVar2.g0;
        knVar.h0 = knVar2.h0;
        knVar.i0 = knVar2.i0;
        knVar.j0 = knVar2.j0;
        knVar.k0 = knVar2.k0;
        knVar.l0 = knVar2.l0;
        knVar.Y = knVar2.Y;
        knVar.Z = knVar2.Z;
        knVar.p0 = knVar2.p0;
        return knVar;
    }
}
