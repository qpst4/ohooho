package defpackage;

import android.R;
import android.animation.Animator;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.ActionMode;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.AbsSeekBar;
import android.widget.EditText;
import androidx.cardview.widget.CardView;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.quickcursor.android.services.CursorAccessibilityService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class i9 implements ni, cy, u00, z00 {
    public static final int[] e = {R.attr.indeterminateDrawable, R.attr.progressDrawable};
    public final /* synthetic */ int b;
    public Object c;
    public Object d;

    public i9(Context context) {
        this.b = 7;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i1.V(com.quickcursor.R.attr.materialCalendarStyle, context, zj0.class.getCanonicalName()).data, ys0.p);
        ix.b(context, typedArrayObtainStyledAttributes.getResourceId(4, 0));
        ix.b(context, typedArrayObtainStyledAttributes.getResourceId(2, 0));
        ix.b(context, typedArrayObtainStyledAttributes.getResourceId(3, 0));
        ix.b(context, typedArrayObtainStyledAttributes.getResourceId(5, 0));
        ColorStateList colorStateListI = yb0.i(context, typedArrayObtainStyledAttributes, 7);
        this.c = ix.b(context, typedArrayObtainStyledAttributes.getResourceId(9, 0));
        ix.b(context, typedArrayObtainStyledAttributes.getResourceId(8, 0));
        this.d = ix.b(context, typedArrayObtainStyledAttributes.getResourceId(10, 0));
        new Paint().setColor(colorStateListI.getDefaultColor());
        typedArrayObtainStyledAttributes.recycle();
    }

    public static void f(Context context, boolean z) {
        if (!jv.a()) {
            si0.a("Material You is not supported on this device.");
            return;
        }
        try {
            Context contextB = jv.b(context);
            TypedArray typedArrayObtainStyledAttributes = contextB.obtainStyledAttributes(new int[]{com.quickcursor.R.attr.colorPrimary});
            int i = 0;
            int color = typedArrayObtainStyledAttributes.getColor(0, 0);
            typedArrayObtainStyledAttributes.recycle();
            int iC = oq0.c((SharedPreferences) pn0.t().d, oq0.T0);
            si0.a("forceChange: " + z + ", oldPrimary: " + iC + ", newPrimary: " + color);
            if (!z && color == iC) {
                return;
            }
            boolean z2 = color == contextB.getResources().getColor(R.color.system_accent1_600, contextB.getTheme());
            int color2 = contextB.getResources().getColor(R.color.system_accent1_100, contextB.getTheme());
            int color3 = z2 ? contextB.getResources().getColor(R.color.system_accent1_100, contextB.getTheme()) : contextB.getResources().getColor(R.color.system_accent2_700, contextB.getTheme());
            int color4 = z2 ? contextB.getResources().getColor(R.color.system_accent1_50, contextB.getTheme()) : contextB.getResources().getColor(R.color.system_accent2_800, contextB.getTheme());
            int color5 = z2 ? contextB.getResources().getColor(R.color.system_accent1_800, contextB.getTheme()) : contextB.getResources().getColor(R.color.system_accent2_50, contextB.getTheme());
            int iF = z2 ? wl.f(color5, 100) : wl.f(color4, 230);
            si0.a("Light theme: " + z2 + ", primary: " + Integer.toHexString(color) + " accent: " + Integer.toHexString(color2));
            SharedPreferences.Editor editorEdit = ((SharedPreferences) pn0.e.d).edit();
            editorEdit.putInt(oq0.c0.name(), color2);
            editorEdit.putInt(oq0.r0.name(), color2);
            editorEdit.putInt(oq0.W.name(), color2);
            editorEdit.putInt(oq0.Z.name(), color2);
            editorEdit.putInt(oq0.e0.name(), wl.f(color2, 230));
            editorEdit.putInt(oq0.y0.name(), wl.f(color3, 230));
            editorEdit.putInt(oq0.w0.name(), wl.f(color4, 230));
            editorEdit.putInt(oq0.C0.name(), color5);
            editorEdit.putInt(oq0.A0.name(), iF);
            for (uv0 uv0Var : xv0.d.c.values()) {
                ArrayList arrayList = new ArrayList(uv0Var.l().l());
                arrayList.addAll(uv0Var.d().c());
                int size = arrayList.size();
                int i2 = i;
                while (i2 < size) {
                    Object obj = arrayList.get(i2);
                    i2++;
                    f91 f91Var = (f91) obj;
                    da1 da1VarD = f91Var.d();
                    da1VarD.t(wl.f(color2, 180));
                    da1VarD.u(wl.f(color2, 180));
                    da1VarD.z(color2);
                    q91 q91VarJ = f91Var.b().j();
                    q91VarJ.o(wl.f(color3, 230));
                    q91VarJ.p(wl.f(color4, 230));
                    q91VarJ.q(iF);
                    q91VarJ.m(color5);
                    o91 o91VarB = f91Var.b().b();
                    o91VarB.h(color5);
                    o91VarB.g(wl.f(color3, 230));
                    i = 0;
                }
            }
            editorEdit.apply();
            xv0.d.c();
            ((SharedPreferences) pn0.t().d).edit().putInt(oq0.T0.name(), color).apply();
            si0.a("Colors changed.");
            CursorAccessibilityService.k(true);
        } catch (Exception e2) {
            si0.b("Material You is supported but an exception occured: " + e2);
        }
    }

    public static int y(int i, int i2) {
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < i; i5++) {
            i3++;
            if (i3 == i2) {
                i4++;
                i3 = 0;
            } else if (i3 > i2) {
                i4++;
                i3 = 1;
            }
        }
        return i3 + 1 > i2 ? i4 + 1 : i4;
    }

    public void A(AttributeSet attributeSet, int i) {
        boolean z = true;
        switch (this.b) {
            case 0:
                AbsSeekBar absSeekBar = (AbsSeekBar) this.c;
                ra raVarM = ra.M(absSeekBar.getContext(), attributeSet, e, i);
                Drawable drawableZ = raVarM.z(0);
                if (drawableZ != null) {
                    if (drawableZ instanceof AnimationDrawable) {
                        AnimationDrawable animationDrawable = (AnimationDrawable) drawableZ;
                        int numberOfFrames = animationDrawable.getNumberOfFrames();
                        AnimationDrawable animationDrawable2 = new AnimationDrawable();
                        animationDrawable2.setOneShot(animationDrawable.isOneShot());
                        for (int i2 = 0; i2 < numberOfFrames; i2++) {
                            Drawable drawableJ = J(animationDrawable.getFrame(i2), true);
                            drawableJ.setLevel(10000);
                            animationDrawable2.addFrame(drawableJ, animationDrawable.getDuration(i2));
                        }
                        animationDrawable2.setLevel(10000);
                        drawableZ = animationDrawable2;
                    }
                    absSeekBar.setIndeterminateDrawable(drawableZ);
                }
                Drawable drawableZ2 = raVarM.z(1);
                if (drawableZ2 != null) {
                    absSeekBar.setProgressDrawable(J(drawableZ2, false));
                }
                raVarM.O();
                return;
            default:
                TypedArray typedArrayObtainStyledAttributes = ((EditText) this.c).getContext().obtainStyledAttributes(attributeSet, zs0.i, i, 0);
                try {
                    if (typedArrayObtainStyledAttributes.hasValue(14)) {
                        z = typedArrayObtainStyledAttributes.getBoolean(14, true);
                        break;
                    }
                    typedArrayObtainStyledAttributes.recycle();
                    H(z);
                    return;
                } catch (Throwable th) {
                    typedArrayObtainStyledAttributes.recycle();
                    throw th;
                }
        }
    }

    public xx B(InputConnection inputConnection, EditorInfo editorInfo) {
        InputConnection inputConnection2;
        sp1 sp1Var = (sp1) this.d;
        if (inputConnection == null) {
            sp1Var.getClass();
            inputConnection2 = null;
        } else {
            i9 i9Var = (i9) sp1Var.c;
            i9Var.getClass();
            if (!(inputConnection instanceof xx)) {
                inputConnection = new xx(editorInfo, inputConnection, (EditText) i9Var.c);
            }
            inputConnection2 = inputConnection;
        }
        return (xx) inputConnection2;
    }

    public void C(e2 e2Var) {
        g7 g7Var = (g7) this.c;
        ((ActionMode.Callback) g7Var.c).onDestroyActionMode(g7Var.j(e2Var));
        y8 y8Var = (y8) this.d;
        if (y8Var.w != null) {
            y8Var.m.getDecorView().removeCallbacks(y8Var.x);
        }
        if (y8Var.v != null) {
            ng1 ng1Var = y8Var.y;
            if (ng1Var != null) {
                ng1Var.b();
            }
            ng1 ng1VarA = uf1.a(y8Var.v);
            ng1VarA.a(0.0f);
            y8Var.y = ng1VarA;
            ng1VarA.d(new n8(2, this));
        }
        y8Var.u = null;
        ViewGroup viewGroup = y8Var.A;
        WeakHashMap weakHashMap = uf1.a;
        jf1.c(viewGroup);
        y8Var.I();
    }

    public boolean D(e2 e2Var, Menu menu) {
        ViewGroup viewGroup = ((y8) this.d).A;
        WeakHashMap weakHashMap = uf1.a;
        jf1.c(viewGroup);
        g7 g7Var = (g7) this.c;
        ActionMode.Callback callback = (ActionMode.Callback) g7Var.c;
        i31 i31VarJ = g7Var.j(e2Var);
        t01 t01Var = (t01) g7Var.e;
        Menu sl0Var = (Menu) t01Var.get(menu);
        if (sl0Var == null) {
            sl0Var = new sl0((Context) g7Var.d, (zk0) menu);
            t01Var.put(menu, sl0Var);
        }
        return callback.onPrepareActionMode(i31VarJ, sl0Var);
    }

    public void E(ta0 ta0Var) {
        sa0 sa0Var = (sa0) this.c;
        if (ta0Var != null) {
            sa0Var.a = ta0Var;
            ((v40) this.d).g(sa0Var.a());
        }
    }

    public void F(r20 r20Var) {
        pv0 pv0Var = (pv0) this.d;
        tb0 tb0Var = (tb0) this.c;
        int i = r20Var.b;
        if (i != 0) {
            pv0Var.execute(new hi(i, 0, tb0Var));
        } else {
            pv0Var.execute(new vn1(tb0Var, 5, r20Var.a));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:145:0x0209, code lost:
    
        continue;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0110 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0109 A[Catch: IOException -> 0x0091, XmlPullParserException -> 0x0094, TryCatch #2 {IOException -> 0x0091, XmlPullParserException -> 0x0094, blocks: (B:20:0x0062, B:97:0x0209, B:28:0x0074, B:29:0x0082, B:31:0x0087, B:38:0x0097, B:46:0x00b1, B:41:0x00a0, B:44:0x00a9, B:47:0x00bf, B:51:0x00ce, B:53:0x00d6, B:54:0x00e0, B:63:0x0109, B:64:0x0110, B:65:0x0128, B:57:0x00e9, B:59:0x00f1, B:60:0x00ff, B:66:0x0129, B:68:0x0131, B:69:0x013f, B:72:0x0149, B:73:0x0154, B:74:0x016c, B:75:0x016d, B:78:0x0177, B:79:0x0182, B:80:0x019a, B:81:0x019b, B:83:0x01a3, B:84:0x01ac, B:87:0x01b6, B:88:0x01c0, B:89:0x01d8, B:90:0x01d9, B:93:0x01e3, B:94:0x01ed, B:95:0x0205, B:96:0x0206), top: B:105:0x0062 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void G(android.content.Context r12, android.content.res.XmlResourceParser r13) {
        /*
            Method dump skipped, instruction units count: 608
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.i9.G(android.content.Context, android.content.res.XmlResourceParser):void");
    }

    public void H(boolean z) {
        gy gyVar = (gy) ((i9) ((sp1) this.d).c).d;
        if (gyVar.d != z) {
            if (gyVar.c != null) {
                sx sxVarA = sx.a();
                fy fyVar = gyVar.c;
                sxVarA.getClass();
                f01.k("initCallback cannot be null", fyVar);
                ReentrantReadWriteLock reentrantReadWriteLock = sxVarA.a;
                reentrantReadWriteLock.writeLock().lock();
                try {
                    sxVarA.b.remove(fyVar);
                } finally {
                    reentrantReadWriteLock.writeLock().unlock();
                }
            }
            gyVar.d = z;
            if (z) {
                gy.a(gyVar.b, sx.a().b());
            }
        }
    }

    public void I(int i, int i2, int i3, int i4) {
        CardView cardView = (CardView) this.d;
        cardView.e.set(i, i2, i3, i4);
        Rect rect = cardView.d;
        super/*android.view.View*/.setPadding(i + rect.left, i2 + rect.top, i3 + rect.right, i4 + rect.bottom);
    }

    public Drawable J(Drawable drawable, boolean z) {
        if (!(drawable instanceof LayerDrawable)) {
            if (!(drawable instanceof BitmapDrawable)) {
                return drawable;
            }
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            Bitmap bitmap = bitmapDrawable.getBitmap();
            if (((Bitmap) this.d) == null) {
                this.d = bitmap;
            }
            ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null));
            shapeDrawable.getPaint().setShader(new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP));
            shapeDrawable.getPaint().setColorFilter(bitmapDrawable.getPaint().getColorFilter());
            return z ? new ClipDrawable(shapeDrawable, 3, 1) : shapeDrawable;
        }
        LayerDrawable layerDrawable = (LayerDrawable) drawable;
        int numberOfLayers = layerDrawable.getNumberOfLayers();
        Drawable[] drawableArr = new Drawable[numberOfLayers];
        for (int i = 0; i < numberOfLayers; i++) {
            int id = layerDrawable.getId(i);
            drawableArr[i] = J(layerDrawable.getDrawable(i), id == 16908301 || id == 16908303);
        }
        LayerDrawable layerDrawable2 = new LayerDrawable(drawableArr);
        for (int i2 = 0; i2 < numberOfLayers; i2++) {
            layerDrawable2.setId(i2, layerDrawable.getId(i2));
            layerDrawable2.setLayerGravity(i2, layerDrawable.getLayerGravity(i2));
            layerDrawable2.setLayerWidth(i2, layerDrawable.getLayerWidth(i2));
            layerDrawable2.setLayerHeight(i2, layerDrawable.getLayerHeight(i2));
            layerDrawable2.setLayerInsetLeft(i2, layerDrawable.getLayerInsetLeft(i2));
            layerDrawable2.setLayerInsetRight(i2, layerDrawable.getLayerInsetRight(i2));
            layerDrawable2.setLayerInsetTop(i2, layerDrawable.getLayerInsetTop(i2));
            layerDrawable2.setLayerInsetBottom(i2, layerDrawable.getLayerInsetBottom(i2));
            layerDrawable2.setLayerInsetStart(i2, layerDrawable.getLayerInsetStart(i2));
            layerDrawable2.setLayerInsetEnd(i2, layerDrawable.getLayerInsetEnd(i2));
        }
        return layerDrawable2;
    }

    @Override // defpackage.cy
    public Object a() {
        return (fd1) this.c;
    }

    @Override // defpackage.u00
    public int b() {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        ExtendedFloatingActionButton extendedFloatingActionButton = ((q00) this.c).c;
        ExtendedFloatingActionButton extendedFloatingActionButton2 = (ExtendedFloatingActionButton) this.d;
        int i = extendedFloatingActionButton2.I;
        if (i != -1) {
            return (i == 0 || i == -2) ? extendedFloatingActionButton.getMeasuredHeight() : i;
        }
        if (!(extendedFloatingActionButton2.getParent() instanceof View)) {
            return extendedFloatingActionButton.getMeasuredHeight();
        }
        View view = (View) extendedFloatingActionButton2.getParent();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null || layoutParams.height != -2) {
            return (view.getHeight() - ((!(extendedFloatingActionButton2.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) || (marginLayoutParams = (ViewGroup.MarginLayoutParams) extendedFloatingActionButton2.getLayoutParams()) == null) ? 0 : marginLayoutParams.topMargin + marginLayoutParams.bottomMargin)) - (view.getPaddingBottom() + view.getPaddingTop());
        }
        return extendedFloatingActionButton.getMeasuredHeight();
    }

    @Override // defpackage.u00
    public int c() {
        return ((ExtendedFloatingActionButton) this.d).B;
    }

    @Override // defpackage.u00
    public int d() {
        return ((ExtendedFloatingActionButton) this.d).A;
    }

    @Override // defpackage.cy
    public boolean e(CharSequence charSequence, int i, int i2, uc1 uc1Var) {
        if ((uc1Var.c & 4) > 0) {
            return true;
        }
        if (((fd1) this.c) == null) {
            this.c = new fd1(charSequence instanceof Spannable ? (Spannable) charSequence : new SpannableString(charSequence));
        }
        ((c70) this.d).getClass();
        ((fd1) this.c).setSpan(new vc1(uc1Var), i, i2, 33);
        return true;
    }

    public void g(boolean z) {
        j30 j30Var = ((y30) this.d).v;
        if (j30Var != null) {
            j30Var.x().l.g(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.c).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                s1.d();
            } else {
                if (!z) {
                    throw null;
                }
                throw null;
            }
        }
    }

    @Override // defpackage.wr0
    public Object get() {
        return new tl0((Context) ((m0) this.c).b, (ra) ((sp1) this.d).get());
    }

    public void h(boolean z) {
        y30 y30Var = (y30) this.d;
        z7 z7Var = y30Var.t.n;
        j30 j30Var = y30Var.v;
        if (j30Var != null) {
            j30Var.x().l.h(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.c).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                s1.d();
            } else {
                if (!z) {
                    throw null;
                }
                throw null;
            }
        }
    }

    @Override // defpackage.u00
    public int i() {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        q00 q00Var = (q00) this.c;
        ExtendedFloatingActionButton extendedFloatingActionButton = (ExtendedFloatingActionButton) this.d;
        if (!(extendedFloatingActionButton.getParent() instanceof View)) {
            return q00Var.i();
        }
        View view = (View) extendedFloatingActionButton.getParent();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null || layoutParams.width != -2) {
            return (view.getWidth() - ((!(extendedFloatingActionButton.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) || (marginLayoutParams = (ViewGroup.MarginLayoutParams) extendedFloatingActionButton.getLayoutParams()) == null) ? 0 : marginLayoutParams.leftMargin + marginLayoutParams.rightMargin)) - (view.getPaddingRight() + view.getPaddingLeft());
        }
        return q00Var.i();
    }

    @Override // defpackage.u00
    public ViewGroup.LayoutParams j() {
        int i = ((ExtendedFloatingActionButton) this.d).I;
        if (i == 0) {
            i = -2;
        }
        return new ViewGroup.LayoutParams(-1, i);
    }

    public void k(boolean z) {
        j30 j30Var = ((y30) this.d).v;
        if (j30Var != null) {
            j30Var.x().l.k(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.c).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                s1.d();
            } else {
                if (!z) {
                    throw null;
                }
                throw null;
            }
        }
    }

    public void l(boolean z) {
        j30 j30Var = ((y30) this.d).v;
        if (j30Var != null) {
            j30Var.x().l.l(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.c).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                s1.d();
            } else {
                if (!z) {
                    throw null;
                }
                throw null;
            }
        }
    }

    public void m(boolean z) {
        j30 j30Var = ((y30) this.d).v;
        if (j30Var != null) {
            j30Var.x().l.m(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.c).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                s1.d();
            } else {
                if (!z) {
                    throw null;
                }
                throw null;
            }
        }
    }

    public void n(boolean z) {
        j30 j30Var = ((y30) this.d).v;
        if (j30Var != null) {
            j30Var.x().l.n(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.c).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                s1.d();
            } else {
                if (!z) {
                    throw null;
                }
                throw null;
            }
        }
    }

    public void o(boolean z) {
        y30 y30Var = (y30) this.d;
        z7 z7Var = y30Var.t.n;
        j30 j30Var = y30Var.v;
        if (j30Var != null) {
            j30Var.x().l.o(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.c).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                s1.d();
            } else {
                if (!z) {
                    throw null;
                }
                throw null;
            }
        }
    }

    @Override // defpackage.ni
    public void onCancel() {
        ((Animator) this.c).end();
        if (y30.I(2)) {
            Log.v("FragmentManager", "Animator from operation " + ((v11) this.d) + " has been canceled.");
        }
    }

    public void p(boolean z) {
        j30 j30Var = ((y30) this.d).v;
        if (j30Var != null) {
            j30Var.x().l.p(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.c).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                s1.d();
            } else {
                if (!z) {
                    throw null;
                }
                throw null;
            }
        }
    }

    public void q(boolean z) {
        j30 j30Var = ((y30) this.d).v;
        if (j30Var != null) {
            j30Var.x().l.q(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.c).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                s1.d();
            } else {
                if (!z) {
                    throw null;
                }
                throw null;
            }
        }
    }

    public void r(boolean z) {
        j30 j30Var = ((y30) this.d).v;
        if (j30Var != null) {
            j30Var.x().l.r(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.c).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                s1.d();
            } else {
                if (!z) {
                    throw null;
                }
                throw null;
            }
        }
    }

    public void s(boolean z) {
        j30 j30Var = ((y30) this.d).v;
        if (j30Var != null) {
            j30Var.x().l.s(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.c).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                s1.d();
            } else {
                if (!z) {
                    throw null;
                }
                throw null;
            }
        }
    }

    public void t(boolean z) {
        j30 j30Var = ((y30) this.d).v;
        if (j30Var != null) {
            j30Var.x().l.t(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.c).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                s1.d();
            } else {
                if (!z) {
                    throw null;
                }
                throw null;
            }
        }
    }

    public void u(boolean z) {
        j30 j30Var = ((y30) this.d).v;
        if (j30Var != null) {
            j30Var.x().l.u(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.c).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                s1.d();
            } else {
                if (!z) {
                    throw null;
                }
                throw null;
            }
        }
    }

    public void v(boolean z) {
        j30 j30Var = ((y30) this.d).v;
        if (j30Var != null) {
            j30Var.x().l.v(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.c).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                s1.d();
            } else {
                if (!z) {
                    throw null;
                }
                throw null;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.google.android.datatransport.cct.CctBackendFactory w(java.lang.String r14) {
        /*
            Method dump skipped, instruction units count: 273
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.i9.w(java.lang.String):com.google.android.datatransport.cct.CctBackendFactory");
    }

    public KeyListener x(KeyListener keyListener) {
        if (keyListener instanceof NumberKeyListener) {
            return keyListener;
        }
        ((i9) ((sp1) this.d).c).getClass();
        if (keyListener instanceof ay) {
            return keyListener;
        }
        if (keyListener == null) {
            return null;
        }
        return keyListener instanceof NumberKeyListener ? keyListener : new ay(keyListener);
    }

    public void z() {
        ((SparseIntArray) this.c).clear();
    }

    public /* synthetic */ i9(int i, Object obj) {
        this.b = i;
        this.c = obj;
        this.d = null;
    }

    public /* synthetic */ i9(Object obj, int i, Object obj2) {
        this.b = i;
        this.d = obj;
        this.c = obj2;
    }

    public /* synthetic */ i9(Object obj, Object obj2, int i, boolean z) {
        this.b = i;
        this.c = obj;
        this.d = obj2;
    }

    public i9(gj1 gj1Var, c70 c70Var) {
        this.b = 1;
        this.d = "ClientTelemetry.API";
        this.c = gj1Var;
    }

    public i9(CursorAccessibilityService cursorAccessibilityService) {
        this.b = 26;
        this.c = new rr(100L, 500L);
        this.d = cursorAccessibilityService;
    }

    public i9(AbsSeekBar absSeekBar) {
        this.b = 0;
        this.c = absSeekBar;
    }

    public i9(EditText editText, int i) {
        this.b = i;
        switch (i) {
            case 14:
                this.c = editText;
                gy gyVar = new gy(editText);
                this.d = gyVar;
                editText.addTextChangedListener(gyVar);
                if (vx.b == null) {
                    synchronized (vx.a) {
                        try {
                            if (vx.b == null) {
                                vx vxVar = new vx();
                                try {
                                    vx.c = Class.forName("android.text.DynamicLayout$ChangeWatcher", false, vx.class.getClassLoader());
                                    break;
                                } catch (Throwable unused) {
                                }
                                vx.b = vxVar;
                            }
                        } finally {
                        }
                        break;
                    }
                }
                editText.setEditableFactory(vx.b);
                return;
            default:
                this.c = editText;
                this.d = new sp1(editText);
                return;
        }
    }

    public i9(y30 y30Var) {
        this.b = 19;
        this.c = new CopyOnWriteArrayList();
        this.d = y30Var;
    }

    public /* synthetic */ i9(int i) {
        this.b = i;
    }

    public i9(Animator animator) {
        this.b = 18;
        this.c = null;
        this.d = animator;
    }

    public i9(ArrayList arrayList, ArrayList arrayList2) {
        this.b = 20;
        int size = arrayList.size();
        this.c = new int[size];
        this.d = new float[size];
        for (int i = 0; i < size; i++) {
            ((int[]) this.c)[i] = ((Integer) arrayList.get(i)).intValue();
            ((float[]) this.d)[i] = ((Float) arrayList2.get(i)).floatValue();
        }
    }

    public i9(int i, int i2) {
        this.b = 20;
        this.c = new int[]{i, i2};
        this.d = new float[]{0.0f, 1.0f};
    }

    public i9(int i, int i2, int i3) {
        this.b = 20;
        this.c = new int[]{i, i2, i3};
        this.d = new float[]{0.0f, 0.5f, 1.0f};
    }

    public i9(CardView cardView) {
        this.b = 9;
        this.d = cardView;
    }

    public i9() {
        this.b = 21;
        this.c = new SparseIntArray();
        this.d = new SparseIntArray();
    }
}
