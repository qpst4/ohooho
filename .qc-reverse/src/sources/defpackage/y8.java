package defpackage;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.ContentFrameLayout;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class y8 extends k8 implements xk0, LayoutInflater.Factory2 {
    public static final t01 h0 = new t01(0);
    public static final int[] i0 = {R.attr.windowBackground};
    public static final boolean j0 = !"robolectric".equals(Build.FINGERPRINT);
    public ViewGroup A;
    public TextView B;
    public View C;
    public boolean D;
    public boolean E;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean I;
    public boolean J;
    public boolean K;
    public x8[] L;
    public x8 M;
    public boolean N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public Configuration R;
    public final int S;
    public int T;
    public int U;
    public boolean V;
    public t8 W;
    public t8 X;
    public boolean Y;
    public int Z;
    public boolean b0;
    public Rect c0;
    public Rect d0;
    public qa e0;
    public OnBackInvokedDispatcher f0;
    public OnBackInvokedCallback g0;
    public final Object k;
    public final Context l;
    public Window m;
    public s8 n;
    public j1 o;
    public m31 p;
    public CharSequence q;
    public ActionBarOverlayLayout r;
    public m8 s;
    public m8 t;
    public e2 u;
    public ActionBarContextView v;
    public PopupWindow w;
    public l8 x;
    public boolean z;
    public ng1 y = null;
    public final l8 a0 = new l8(this, 0);

    public y8(Context context, Window window, b8 b8Var, Object obj) {
        z7 z7Var = null;
        this.S = -100;
        this.l = context;
        this.k = obj;
        if (obj instanceof Dialog) {
            while (true) {
                if (context != null) {
                    if (!(context instanceof z7)) {
                        if (!(context instanceof ContextWrapper)) {
                            break;
                        } else {
                            context = ((ContextWrapper) context).getBaseContext();
                        }
                    } else {
                        z7Var = (z7) context;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (z7Var != null) {
                this.S = ((y8) z7Var.u()).S;
            }
        }
        if (this.S == -100) {
            String name = this.k.getClass().getName();
            t01 t01Var = h0;
            Integer num = (Integer) t01Var.get(name);
            if (num != null) {
                this.S = num.intValue();
                t01Var.remove(this.k.getClass().getName());
            }
        }
        if (window != null) {
            o(window);
        }
        b9.d();
    }

    public static ai0 p(Context context) {
        ai0 ai0Var;
        ai0 ai0Var2;
        if (Build.VERSION.SDK_INT >= 33 || (ai0Var = k8.d) == null) {
            return null;
        }
        bi0 bi0Var = ai0Var.a;
        ai0 ai0VarB = p8.b(context.getApplicationContext().getResources().getConfiguration());
        if (bi0Var.a.isEmpty()) {
            ai0Var2 = ai0.b;
        } else {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            int i = 0;
            while (i < ai0VarB.a.a.size() + bi0Var.a.size()) {
                Locale locale = i < bi0Var.a.size() ? bi0Var.a.get(i) : ai0VarB.a.a.get(i - bi0Var.a.size());
                if (locale != null) {
                    linkedHashSet.add(locale);
                }
                i++;
            }
            ai0Var2 = new ai0(new bi0(new LocaleList((Locale[]) linkedHashSet.toArray(new Locale[linkedHashSet.size()]))));
        }
        return ai0Var2.a.a.isEmpty() ? ai0VarB : ai0Var2;
    }

    public static Configuration t(Context context, int i, ai0 ai0Var, Configuration configuration, boolean z) {
        int i2 = i != 1 ? i != 2 ? z ? 0 : context.getApplicationContext().getResources().getConfiguration().uiMode & 48 : 32 : 16;
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i2 | (configuration2.uiMode & (-49));
        if (ai0Var != null) {
            p8.d(configuration2, ai0Var);
        }
        return configuration2;
    }

    public final void A() {
        w();
        if (this.F && this.o == null) {
            Object obj = this.k;
            if (obj instanceof Activity) {
                this.o = new vh1((Activity) obj, this.G);
            } else if (obj instanceof Dialog) {
                this.o = new vh1((Dialog) obj);
            }
            j1 j1Var = this.o;
            if (j1Var != null) {
                j1Var.n(this.b0);
            }
        }
    }

    public final void B(int i) {
        this.Z = (1 << i) | this.Z;
        if (this.Y) {
            return;
        }
        View decorView = this.m.getDecorView();
        WeakHashMap weakHashMap = uf1.a;
        decorView.postOnAnimation(this.a0);
        this.Y = true;
    }

    public final int C(Context context, int i) {
        if (i != -100) {
            if (i != -1) {
                if (i != 0) {
                    if (i != 1 && i != 2) {
                        if (i != 3) {
                            s1.f("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
                            return 0;
                        }
                        if (this.X == null) {
                            this.X = new t8(this, context);
                        }
                        return this.X.f();
                    }
                } else if (((UiModeManager) context.getApplicationContext().getSystemService("uimode")).getNightMode() != 0) {
                    return y(context).f();
                }
            }
            return i;
        }
        return -1;
    }

    public final boolean D() {
        boolean z = this.N;
        this.N = false;
        x8 x8VarZ = z(0);
        if (!x8VarZ.m) {
            e2 e2Var = this.u;
            if (e2Var != null) {
                e2Var.a();
                return true;
            }
            A();
            j1 j1Var = this.o;
            if (j1Var == null || !j1Var.b()) {
                return false;
            }
        } else if (!z) {
            s(x8VarZ, true);
            return true;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:87:0x0176, code lost:
    
        if (r2.g.getCount() > 0) goto L88;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:105:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void E(defpackage.x8 r18, android.view.KeyEvent r19) {
        /*
            Method dump skipped, instruction units count: 474
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.y8.E(x8, android.view.KeyEvent):void");
    }

    public final boolean F(x8 x8Var, int i, KeyEvent keyEvent) {
        zk0 zk0Var;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((x8Var.k || G(x8Var, keyEvent)) && (zk0Var = x8Var.h) != null) {
            return zk0Var.performShortcut(i, keyEvent, 1);
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x00d6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean G(defpackage.x8 r13, android.view.KeyEvent r14) {
        /*
            Method dump skipped, instruction units count: 361
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.y8.G(x8, android.view.KeyEvent):boolean");
    }

    public final void H() {
        if (this.z) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    public final void I() {
        OnBackInvokedCallback onBackInvokedCallback;
        if (Build.VERSION.SDK_INT >= 33) {
            boolean z = false;
            if (this.f0 != null && (z(0).m || this.u != null)) {
                z = true;
            }
            if (z && this.g0 == null) {
                this.g0 = r8.b(this.f0, this);
            } else {
                if (z || (onBackInvokedCallback = this.g0) == null) {
                    return;
                }
                r8.c(this.f0, onBackInvokedCallback);
                this.g0 = null;
            }
        }
    }

    @Override // defpackage.k8
    public final void a() {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.l);
        if (layoutInflaterFrom.getFactory() == null) {
            layoutInflaterFrom.setFactory2(this);
        } else {
            if (layoutInflaterFrom.getFactory2() instanceof y8) {
                return;
            }
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    @Override // defpackage.k8
    public final void b() {
        if (this.o != null) {
            A();
            if (this.o.f()) {
                return;
            }
            B(0);
        }
    }

    @Override // defpackage.k8
    public final void d() {
        String strU;
        this.O = true;
        m(false, true);
        x();
        Object obj = this.k;
        if (obj instanceof Activity) {
            try {
                Activity activity = (Activity) obj;
                try {
                    strU = xr.u(activity, activity.getComponentName());
                } catch (PackageManager.NameNotFoundException e) {
                    throw new IllegalArgumentException(e);
                }
            } catch (IllegalArgumentException unused) {
                strU = null;
            }
            if (strU != null) {
                j1 j1Var = this.o;
                if (j1Var == null) {
                    this.b0 = true;
                } else {
                    j1Var.n(true);
                }
            }
            synchronized (k8.i) {
                k8.g(this);
                k8.h.add(new WeakReference(this));
            }
        }
        this.R = new Configuration(this.l.getResources().getConfiguration());
        this.P = true;
    }

    @Override // defpackage.xk0
    public final boolean e(zk0 zk0Var, MenuItem menuItem) {
        x8 x8Var;
        Window.Callback callback = this.m.getCallback();
        if (callback != null && !this.Q) {
            zk0 zk0VarK = zk0Var.k();
            x8[] x8VarArr = this.L;
            int length = x8VarArr != null ? x8VarArr.length : 0;
            int i = 0;
            while (true) {
                if (i < length) {
                    x8Var = x8VarArr[i];
                    if (x8Var != null && x8Var.h == zk0VarK) {
                        break;
                    }
                    i++;
                } else {
                    x8Var = null;
                    break;
                }
            }
            if (x8Var != null) {
                return callback.onMenuItemSelected(x8Var.a, menuItem);
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x004d  */
    @Override // defpackage.k8
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.k
            boolean r0 = r0 instanceof android.app.Activity
            if (r0 == 0) goto L11
            java.lang.Object r0 = defpackage.k8.i
            monitor-enter(r0)
            defpackage.k8.g(r3)     // Catch: java.lang.Throwable -> Le
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Le
            goto L11
        Le:
            r3 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Le
            throw r3
        L11:
            boolean r0 = r3.Y
            if (r0 == 0) goto L20
            android.view.Window r0 = r3.m
            android.view.View r0 = r0.getDecorView()
            l8 r1 = r3.a0
            r0.removeCallbacks(r1)
        L20:
            r0 = 1
            r3.Q = r0
            int r0 = r3.S
            r1 = -100
            if (r0 == r1) goto L4d
            java.lang.Object r0 = r3.k
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L4d
            android.app.Activity r0 = (android.app.Activity) r0
            boolean r0 = r0.isChangingConfigurations()
            if (r0 == 0) goto L4d
            t01 r0 = defpackage.y8.h0
            java.lang.Object r1 = r3.k
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            int r2 = r3.S
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.put(r1, r2)
            goto L5c
        L4d:
            t01 r0 = defpackage.y8.h0
            java.lang.Object r1 = r3.k
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            r0.remove(r1)
        L5c:
            j1 r0 = r3.o
            if (r0 == 0) goto L63
            r0.h()
        L63:
            t8 r0 = r3.W
            if (r0 == 0) goto L6a
            r0.c()
        L6a:
            t8 r3 = r3.X
            if (r3 == 0) goto L71
            r3.c()
        L71:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.y8.f():void");
    }

    @Override // defpackage.k8
    public final boolean h(int i) {
        if (i == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            i = 108;
        } else if (i == 9) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            i = 109;
        }
        if (this.J && i == 108) {
            return false;
        }
        if (this.F && i == 1) {
            this.F = false;
        }
        if (i == 1) {
            H();
            this.J = true;
            return true;
        }
        if (i == 2) {
            H();
            this.D = true;
            return true;
        }
        if (i == 5) {
            H();
            this.E = true;
            return true;
        }
        if (i == 10) {
            H();
            this.H = true;
            return true;
        }
        if (i == 108) {
            H();
            this.F = true;
            return true;
        }
        if (i != 109) {
            return this.m.requestFeature(i);
        }
        H();
        this.G = true;
        return true;
    }

    @Override // defpackage.k8
    public final void i(int i) {
        w();
        ViewGroup viewGroup = (ViewGroup) this.A.findViewById(R.id.content);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.l).inflate(i, viewGroup);
        this.n.a(this.m.getCallback());
    }

    @Override // defpackage.k8
    public final void j(View view) {
        w();
        ViewGroup viewGroup = (ViewGroup) this.A.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.n.a(this.m.getCallback());
    }

    @Override // defpackage.k8
    public final void k(View view, ViewGroup.LayoutParams layoutParams) {
        w();
        ViewGroup viewGroup = (ViewGroup) this.A.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.n.a(this.m.getCallback());
    }

    @Override // defpackage.k8
    public final void l(CharSequence charSequence) {
        this.q = charSequence;
        ActionBarOverlayLayout actionBarOverlayLayout = this.r;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setWindowTitle(charSequence);
            return;
        }
        j1 j1Var = this.o;
        if (j1Var != null) {
            j1Var.w(charSequence);
            return;
        }
        TextView textView = this.B;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:114:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00f8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean m(boolean r14, boolean r15) {
        /*
            Method dump skipped, instruction units count: 592
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.y8.m(boolean, boolean):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0044, code lost:
    
        if (r6.h() != false) goto L20;
     */
    @Override // defpackage.xk0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void n(defpackage.zk0 r6) {
        /*
            Method dump skipped, instruction units count: 215
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.y8.n(zk0):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void o(android.view.Window r4) {
        /*
            r3 = this;
            android.view.Window r0 = r3.m
            java.lang.String r1 = "AppCompat has already installed itself into the Window"
            if (r0 != 0) goto L64
            android.view.Window$Callback r0 = r4.getCallback()
            boolean r2 = r0 instanceof defpackage.s8
            if (r2 != 0) goto L60
            s8 r1 = new s8
            r1.<init>(r3, r0)
            r3.n = r1
            r4.setCallback(r1)
            android.content.Context r0 = r3.l
            int[] r1 = defpackage.y8.i0
            r2 = 0
            ra r0 = defpackage.ra.L(r0, r2, r1)
            r1 = 0
            android.graphics.drawable.Drawable r1 = r0.z(r1)
            if (r1 == 0) goto L2b
            r4.setBackgroundDrawable(r1)
        L2b:
            r0.O()
            r3.m = r4
            int r4 = android.os.Build.VERSION.SDK_INT
            r0 = 33
            if (r4 < r0) goto L5f
            android.window.OnBackInvokedDispatcher r4 = r3.f0
            if (r4 != 0) goto L5f
            if (r4 == 0) goto L45
            android.window.OnBackInvokedCallback r0 = r3.g0
            if (r0 == 0) goto L45
            defpackage.r8.c(r4, r0)
            r3.g0 = r2
        L45:
            java.lang.Object r4 = r3.k
            boolean r0 = r4 instanceof android.app.Activity
            if (r0 == 0) goto L5a
            android.app.Activity r4 = (android.app.Activity) r4
            android.view.Window r0 = r4.getWindow()
            if (r0 == 0) goto L5a
            android.window.OnBackInvokedDispatcher r4 = defpackage.r8.a(r4)
            r3.f0 = r4
            goto L5c
        L5a:
            r3.f0 = r2
        L5c:
            r3.I()
        L5f:
            return
        L60:
            defpackage.s1.f(r1)
            return
        L64:
            defpackage.s1.f(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.y8.o(android.view.Window):void");
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        qa qaVar;
        Context ioVar;
        View k9Var;
        View view2 = null;
        if (this.e0 == null) {
            int[] iArr = zs0.j;
            Context context2 = this.l;
            TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(iArr);
            String string = typedArrayObtainStyledAttributes.getString(116);
            typedArrayObtainStyledAttributes.recycle();
            if (string == null) {
                this.e0 = new qa();
            } else {
                try {
                    this.e0 = (qa) context2.getClassLoader().loadClass(string).getDeclaredConstructor(null).newInstance(null);
                } catch (Throwable th) {
                    Log.i("AppCompatDelegate", "Failed to instantiate custom view inflater " + string + ". Falling back to default.", th);
                    this.e0 = new qa();
                }
            }
        }
        qaVar = this.e0;
        int i = re1.a;
        qaVar.getClass();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, zs0.y, 0, 0);
        int resourceId = typedArrayObtainStyledAttributes2.getResourceId(4, 0);
        if (resourceId != 0) {
            Log.i("AppCompatViewInflater", "app:theme is now deprecated. Please move to using android:theme instead.");
        }
        typedArrayObtainStyledAttributes2.recycle();
        ioVar = (resourceId == 0 || ((context instanceof io) && ((io) context).a == resourceId)) ? context : new io(context, resourceId);
        str.getClass();
        switch (str) {
            case "RatingBar":
                k9Var = new k9(ioVar, attributeSet);
                break;
            case "CheckedTextView":
                k9Var = new d8(ioVar, attributeSet);
                break;
            case "MultiAutoCompleteTextView":
                k9Var = new g9(ioVar, attributeSet);
                break;
            case "TextView":
                k9Var = qaVar.e(ioVar, attributeSet);
                break;
            case "ImageButton":
                k9Var = new e9(ioVar, attributeSet);
                break;
            case "SeekBar":
                k9Var = new m9(ioVar, attributeSet);
                break;
            case "Spinner":
                k9Var = new y9(ioVar, attributeSet);
                break;
            case "RadioButton":
                k9Var = qaVar.d(ioVar, attributeSet);
                break;
            case "ToggleButton":
                k9Var = new oa(ioVar, attributeSet);
                break;
            case "ImageView":
                k9Var = new AppCompatImageView(ioVar, attributeSet);
                break;
            case "AutoCompleteTextView":
                k9Var = qaVar.a(ioVar, attributeSet);
                break;
            case "CheckBox":
                k9Var = qaVar.c(ioVar, attributeSet);
                break;
            case "EditText":
                k9Var = new AppCompatEditText(ioVar, attributeSet);
                break;
            case "Button":
                k9Var = qaVar.b(ioVar, attributeSet);
                break;
            default:
                k9Var = null;
                break;
        }
        if (k9Var == null && context != ioVar) {
            Object[] objArr = qaVar.a;
            if (str.equals("view")) {
                str = attributeSet.getAttributeValue(null, "class");
            }
            try {
                objArr[0] = ioVar;
                objArr[1] = attributeSet;
                if (-1 == str.indexOf(46)) {
                    int i2 = 0;
                    while (true) {
                        String[] strArr = qa.g;
                        if (i2 < 3) {
                            View viewF = qaVar.f(ioVar, str, strArr[i2]);
                            if (viewF != null) {
                                objArr[0] = null;
                                objArr[1] = null;
                                view2 = viewF;
                            } else {
                                i2++;
                            }
                        } else {
                            objArr[0] = null;
                            objArr[1] = null;
                        }
                    }
                } else {
                    View viewF2 = qaVar.f(ioVar, str, null);
                    objArr[0] = null;
                    objArr[1] = null;
                    view2 = viewF2;
                }
            } catch (Exception unused) {
                objArr[0] = null;
                objArr[1] = null;
            } catch (Throwable th2) {
                objArr[0] = null;
                objArr[1] = null;
                throw th2;
            }
            k9Var = view2;
        }
        if (k9Var != null) {
            Context context3 = k9Var.getContext();
            if ((context3 instanceof ContextWrapper) && k9Var.hasOnClickListeners()) {
                TypedArray typedArrayObtainStyledAttributes3 = context3.obtainStyledAttributes(attributeSet, qa.c);
                String string2 = typedArrayObtainStyledAttributes3.getString(0);
                if (string2 != null) {
                    k9Var.setOnClickListener(new pa(k9Var, string2));
                }
                typedArrayObtainStyledAttributes3.recycle();
            }
            if (Build.VERSION.SDK_INT <= 28) {
                TypedArray typedArrayObtainStyledAttributes4 = ioVar.obtainStyledAttributes(attributeSet, qa.d);
                if (typedArrayObtainStyledAttributes4.hasValue(0)) {
                    boolean z = typedArrayObtainStyledAttributes4.getBoolean(0, false);
                    WeakHashMap weakHashMap = uf1.a;
                    new hf1(com.quickcursor.R.id.tag_accessibility_heading, Boolean.class, 0, 28, 3).d(k9Var, Boolean.valueOf(z));
                }
                typedArrayObtainStyledAttributes4.recycle();
                TypedArray typedArrayObtainStyledAttributes5 = ioVar.obtainStyledAttributes(attributeSet, qa.e);
                if (typedArrayObtainStyledAttributes5.hasValue(0)) {
                    uf1.o(k9Var, typedArrayObtainStyledAttributes5.getString(0));
                }
                typedArrayObtainStyledAttributes5.recycle();
                TypedArray typedArrayObtainStyledAttributes6 = ioVar.obtainStyledAttributes(attributeSet, qa.f);
                if (typedArrayObtainStyledAttributes6.hasValue(0)) {
                    boolean z2 = typedArrayObtainStyledAttributes6.getBoolean(0, false);
                    WeakHashMap weakHashMap2 = uf1.a;
                    new hf1(com.quickcursor.R.id.tag_screen_reader_focusable, Boolean.class, 0, 28, 0).d(k9Var, Boolean.valueOf(z2));
                }
                typedArrayObtainStyledAttributes6.recycle();
            }
        }
        return k9Var;
    }

    public final void q(int i, x8 x8Var, zk0 zk0Var) {
        if (zk0Var == null) {
            if (x8Var == null && i >= 0) {
                x8[] x8VarArr = this.L;
                if (i < x8VarArr.length) {
                    x8Var = x8VarArr[i];
                }
            }
            if (x8Var != null) {
                zk0Var = x8Var.h;
            }
        }
        if ((x8Var == null || x8Var.m) && !this.Q) {
            s8 s8Var = this.n;
            Window.Callback callback = this.m.getCallback();
            s8Var.getClass();
            try {
                s8Var.f = true;
                callback.onPanelClosed(i, zk0Var);
            } finally {
                s8Var.f = false;
            }
        }
    }

    public final void r(zk0 zk0Var) {
        a2 a2Var;
        if (this.K) {
            return;
        }
        this.K = true;
        ActionBarOverlayLayout actionBarOverlayLayout = this.r;
        actionBarOverlayLayout.k();
        ActionMenuView actionMenuView = ((b71) actionBarOverlayLayout.f).a.b;
        if (actionMenuView != null && (a2Var = actionMenuView.u) != null) {
            a2Var.d();
            x1 x1Var = a2Var.u;
            if (x1Var != null && x1Var.b()) {
                x1Var.i.dismiss();
            }
        }
        Window.Callback callback = this.m.getCallback();
        if (callback != null && !this.Q) {
            callback.onPanelClosed(108, zk0Var);
        }
        this.K = false;
    }

    public final void s(x8 x8Var, boolean z) {
        w8 w8Var;
        ActionBarOverlayLayout actionBarOverlayLayout;
        if (z && x8Var.a == 0 && (actionBarOverlayLayout = this.r) != null) {
            actionBarOverlayLayout.k();
            if (((b71) actionBarOverlayLayout.f).a.p()) {
                r(x8Var.h);
                return;
            }
        }
        WindowManager windowManager = (WindowManager) this.l.getSystemService("window");
        if (windowManager != null && x8Var.m && (w8Var = x8Var.e) != null) {
            windowManager.removeView(w8Var);
            if (z) {
                q(x8Var.a, x8Var, null);
            }
        }
        x8Var.k = false;
        x8Var.l = false;
        x8Var.m = false;
        x8Var.f = null;
        x8Var.n = true;
        if (this.M == x8Var) {
            this.M = null;
        }
        if (x8Var.a == 0) {
            I();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0113  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean u(android.view.KeyEvent r7) {
        /*
            Method dump skipped, instruction units count: 309
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.y8.u(android.view.KeyEvent):boolean");
    }

    public final void v(int i) {
        x8 x8VarZ = z(i);
        if (x8VarZ.h != null) {
            Bundle bundle = new Bundle();
            x8VarZ.h.t(bundle);
            if (bundle.size() > 0) {
                x8VarZ.p = bundle;
            }
            x8VarZ.h.w();
            x8VarZ.h.clear();
        }
        x8VarZ.o = true;
        x8VarZ.n = true;
        if ((i == 108 || i == 0) && this.r != null) {
            x8 x8VarZ2 = z(0);
            x8VarZ2.k = false;
            G(x8VarZ2, null);
        }
    }

    public final void w() {
        ViewGroup viewGroup;
        if (this.z) {
            return;
        }
        Context context = this.l;
        int[] iArr = zs0.j;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(iArr);
        if (!typedArrayObtainStyledAttributes.hasValue(117)) {
            typedArrayObtainStyledAttributes.recycle();
            s1.f("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
            return;
        }
        int i = 0;
        int i2 = 1;
        if (typedArrayObtainStyledAttributes.getBoolean(126, false)) {
            h(1);
        } else if (typedArrayObtainStyledAttributes.getBoolean(117, false)) {
            h(108);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(118, false)) {
            h(109);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(119, false)) {
            h(10);
        }
        this.I = typedArrayObtainStyledAttributes.getBoolean(0, false);
        typedArrayObtainStyledAttributes.recycle();
        x();
        this.m.getDecorView();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        if (this.J) {
            viewGroup = this.H ? (ViewGroup) layoutInflaterFrom.inflate(com.quickcursor.R.layout.abc_screen_simple_overlay_action_mode, (ViewGroup) null) : (ViewGroup) layoutInflaterFrom.inflate(com.quickcursor.R.layout.abc_screen_simple, (ViewGroup) null);
        } else if (this.I) {
            viewGroup = (ViewGroup) layoutInflaterFrom.inflate(com.quickcursor.R.layout.abc_dialog_title_material, (ViewGroup) null);
            this.G = false;
            this.F = false;
        } else if (this.F) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(com.quickcursor.R.attr.actionBarTheme, typedValue, true);
            viewGroup = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new io(context, typedValue.resourceId) : context).inflate(com.quickcursor.R.layout.abc_screen_toolbar, (ViewGroup) null);
            ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) viewGroup.findViewById(com.quickcursor.R.id.decor_content_parent);
            this.r = actionBarOverlayLayout;
            actionBarOverlayLayout.setWindowCallback(this.m.getCallback());
            if (this.G) {
                this.r.j(109);
            }
            if (this.D) {
                this.r.j(2);
            }
            if (this.E) {
                this.r.j(5);
            }
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.F + ", windowActionBarOverlay: " + this.G + ", android:windowIsFloating: " + this.I + ", windowActionModeOverlay: " + this.H + ", windowNoTitle: " + this.J + " }");
        }
        m8 m8Var = new m8(this, i);
        WeakHashMap weakHashMap = uf1.a;
        lf1.l(viewGroup, m8Var);
        if (this.r == null) {
            this.B = (TextView) viewGroup.findViewById(com.quickcursor.R.id.title);
        }
        boolean z = vg1.a;
        try {
            Method method = viewGroup.getClass().getMethod("makeOptionalFitsSystemWindows", null);
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            method.invoke(viewGroup, null);
        } catch (IllegalAccessException e) {
            Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e);
        } catch (NoSuchMethodException unused) {
            Log.d("ViewUtils", "Could not find method makeOptionalFitsSystemWindows. Oh well...");
        } catch (InvocationTargetException e2) {
            Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e2);
        }
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(com.quickcursor.R.id.action_bar_activity_content);
        ViewGroup viewGroup2 = (ViewGroup) this.m.findViewById(R.id.content);
        if (viewGroup2 != null) {
            while (viewGroup2.getChildCount() > 0) {
                View childAt = viewGroup2.getChildAt(0);
                viewGroup2.removeViewAt(0);
                contentFrameLayout.addView(childAt);
            }
            viewGroup2.setId(-1);
            contentFrameLayout.setId(R.id.content);
            if (viewGroup2 instanceof FrameLayout) {
                ((FrameLayout) viewGroup2).setForeground(null);
            }
        }
        this.m.setContentView(viewGroup);
        contentFrameLayout.setAttachListener(new m8(this, i2));
        this.A = viewGroup;
        Object obj = this.k;
        CharSequence title = obj instanceof Activity ? ((Activity) obj).getTitle() : this.q;
        if (!TextUtils.isEmpty(title)) {
            ActionBarOverlayLayout actionBarOverlayLayout2 = this.r;
            if (actionBarOverlayLayout2 != null) {
                actionBarOverlayLayout2.setWindowTitle(title);
            } else {
                j1 j1Var = this.o;
                if (j1Var != null) {
                    j1Var.w(title);
                } else {
                    TextView textView = this.B;
                    if (textView != null) {
                        textView.setText(title);
                    }
                }
            }
        }
        ContentFrameLayout contentFrameLayout2 = (ContentFrameLayout) this.A.findViewById(R.id.content);
        View decorView = this.m.getDecorView();
        contentFrameLayout2.h.set(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        if (contentFrameLayout2.isLaidOut()) {
            contentFrameLayout2.requestLayout();
        }
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(iArr);
        typedArrayObtainStyledAttributes2.getValue(124, contentFrameLayout2.getMinWidthMajor());
        typedArrayObtainStyledAttributes2.getValue(125, contentFrameLayout2.getMinWidthMinor());
        if (typedArrayObtainStyledAttributes2.hasValue(122)) {
            typedArrayObtainStyledAttributes2.getValue(122, contentFrameLayout2.getFixedWidthMajor());
        }
        if (typedArrayObtainStyledAttributes2.hasValue(123)) {
            typedArrayObtainStyledAttributes2.getValue(123, contentFrameLayout2.getFixedWidthMinor());
        }
        if (typedArrayObtainStyledAttributes2.hasValue(120)) {
            typedArrayObtainStyledAttributes2.getValue(120, contentFrameLayout2.getFixedHeightMajor());
        }
        if (typedArrayObtainStyledAttributes2.hasValue(121)) {
            typedArrayObtainStyledAttributes2.getValue(121, contentFrameLayout2.getFixedHeightMinor());
        }
        typedArrayObtainStyledAttributes2.recycle();
        contentFrameLayout2.requestLayout();
        this.z = true;
        x8 x8VarZ = z(0);
        if (this.Q || x8VarZ.h != null) {
            return;
        }
        B(108);
    }

    public final void x() {
        if (this.m == null) {
            Object obj = this.k;
            if (obj instanceof Activity) {
                o(((Activity) obj).getWindow());
            }
        }
        if (this.m != null) {
            return;
        }
        s1.f("We have not been given a Window");
    }

    public final v8 y(Context context) {
        if (this.W == null) {
            if (ra.h == null) {
                Context applicationContext = context.getApplicationContext();
                ra.h = new ra(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
            }
            this.W = new t8(this, ra.h);
        }
        return this.W;
    }

    public final x8 z(int i) {
        x8[] x8VarArr = this.L;
        if (x8VarArr == null || x8VarArr.length <= i) {
            x8[] x8VarArr2 = new x8[i + 1];
            if (x8VarArr != null) {
                System.arraycopy(x8VarArr, 0, x8VarArr2, 0, x8VarArr.length);
            }
            this.L = x8VarArr2;
            x8VarArr = x8VarArr2;
        }
        x8 x8Var = x8VarArr[i];
        if (x8Var != null) {
            return x8Var;
        }
        x8 x8Var2 = new x8();
        x8Var2.a = i;
        x8Var2.n = false;
        x8VarArr[i] = x8Var2;
        return x8Var2;
    }

    @Override // android.view.LayoutInflater.Factory
    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }
}
