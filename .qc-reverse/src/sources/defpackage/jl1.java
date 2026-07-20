package defpackage;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.appcompat.app.AlertController$RecycleListView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public /* synthetic */ class jl1 implements a1 {
    public int b;
    public Object c;

    public jl1(int i) {
        switch (i) {
            case 6:
                this.b = 1;
                this.c = Collections.singletonList(null);
                break;
            case 7:
            default:
                this.b = 0;
                this.c = new StringBuilder();
                break;
            case 8:
                this.c = new int[10];
                break;
        }
    }

    @Override // defpackage.a1
    public boolean a(View view) {
        ((BottomSheetBehavior) this.c).B(this.b);
        return true;
    }

    public df b() {
        df dfVar = new df();
        dfVar.a = this.b;
        dfVar.b = (String) this.c;
        return dfVar;
    }

    public b7 c() {
        ListAdapter z6Var;
        x6 x6Var = (x6) this.c;
        ContextThemeWrapper contextThemeWrapper = x6Var.a;
        ContextThemeWrapper contextThemeWrapper2 = x6Var.a;
        b7 b7Var = new b7(contextThemeWrapper, this.b);
        View view = x6Var.f;
        a7 a7Var = b7Var.g;
        if (view != null) {
            a7Var.x = view;
        } else {
            CharSequence charSequence = x6Var.e;
            if (charSequence != null) {
                a7Var.d = charSequence;
                TextView textView = a7Var.v;
                if (textView != null) {
                    textView.setText(charSequence);
                }
            }
            Drawable drawable = x6Var.d;
            if (drawable != null) {
                a7Var.t = drawable;
                a7Var.s = 0;
                ImageView imageView = a7Var.u;
                if (imageView != null) {
                    imageView.setVisibility(0);
                    a7Var.u.setImageDrawable(drawable);
                }
            }
            int i = x6Var.c;
            if (i != 0) {
                a7Var.t = null;
                a7Var.s = i;
                ImageView imageView2 = a7Var.u;
                if (imageView2 != null) {
                    if (i != 0) {
                        imageView2.setVisibility(0);
                        a7Var.u.setImageResource(a7Var.s);
                    } else {
                        imageView2.setVisibility(8);
                    }
                }
            }
        }
        CharSequence charSequence2 = x6Var.g;
        if (charSequence2 != null) {
            a7Var.e = charSequence2;
            TextView textView2 = a7Var.w;
            if (textView2 != null) {
                textView2.setText(charSequence2);
            }
        }
        CharSequence charSequence3 = x6Var.h;
        if (charSequence3 != null) {
            a7Var.c(-1, charSequence3, x6Var.i);
        }
        CharSequence charSequence4 = x6Var.j;
        if (charSequence4 != null) {
            a7Var.c(-2, charSequence4, x6Var.k);
        }
        CharSequence charSequence5 = x6Var.l;
        if (charSequence5 != null) {
            a7Var.c(-3, charSequence5, x6Var.m);
        }
        if (x6Var.r != null || x6Var.s != null) {
            AlertController$RecycleListView alertController$RecycleListView = (AlertController$RecycleListView) x6Var.b.inflate(a7Var.B, (ViewGroup) null);
            if (x6Var.w) {
                z6Var = new u6(x6Var, contextThemeWrapper2, a7Var.C, x6Var.r, alertController$RecycleListView);
            } else {
                int i2 = x6Var.x ? a7Var.D : a7Var.E;
                z6Var = x6Var.s;
                if (z6Var == null) {
                    z6Var = new z6(contextThemeWrapper2, i2, R.id.text1, x6Var.r);
                }
            }
            a7Var.y = z6Var;
            a7Var.z = x6Var.y;
            if (x6Var.t != null) {
                alertController$RecycleListView.setOnItemClickListener(new v6(x6Var, a7Var));
            } else if (x6Var.z != null) {
                alertController$RecycleListView.setOnItemClickListener(new w6(x6Var, alertController$RecycleListView, a7Var));
            }
            if (x6Var.x) {
                alertController$RecycleListView.setChoiceMode(1);
            } else if (x6Var.w) {
                alertController$RecycleListView.setChoiceMode(2);
            }
            a7Var.f = alertController$RecycleListView;
        }
        View view2 = x6Var.u;
        if (view2 != null) {
            a7Var.g = view2;
            a7Var.h = false;
        }
        b7Var.setCancelable(x6Var.n);
        if (x6Var.n) {
            b7Var.setCanceledOnTouchOutside(true);
        }
        b7Var.setOnCancelListener(x6Var.o);
        b7Var.setOnDismissListener(x6Var.p);
        DialogInterface.OnKeyListener onKeyListener = x6Var.q;
        if (onKeyListener != null) {
            b7Var.setOnKeyListener(onKeyListener);
        }
        return b7Var;
    }

    public int d() {
        if ((this.b & 128) != 0) {
            return ((int[]) this.c)[7];
        }
        return 65535;
    }

    public void e(int i, int i2) {
        if (i >= 0) {
            int[] iArr = (int[]) this.c;
            if (i >= iArr.length) {
                return;
            }
            this.b = (1 << i) | this.b;
            iArr[i] = i2;
        }
    }

    public void f(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
        x6 x6Var = (x6) this.c;
        x6Var.s = listAdapter;
        x6Var.t = onClickListener;
    }

    public jl1 g(int i) {
        x6 x6Var = (x6) this.c;
        x6Var.g = x6Var.a.getText(i);
        return this;
    }

    public void h(int i, DialogInterface.OnClickListener onClickListener) {
        x6 x6Var = (x6) this.c;
        x6Var.j = x6Var.a.getText(i);
        x6Var.k = onClickListener;
    }

    public void i(int i, DialogInterface.OnClickListener onClickListener) {
        x6 x6Var = (x6) this.c;
        x6Var.l = x6Var.a.getText(i);
        x6Var.m = onClickListener;
    }

    public void j(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        x6 x6Var = (x6) this.c;
        x6Var.l = charSequence;
        x6Var.m = onClickListener;
    }

    public void k(int i, DialogInterface.OnClickListener onClickListener) {
        x6 x6Var = (x6) this.c;
        x6Var.h = x6Var.a.getText(i);
        x6Var.i = onClickListener;
    }

    public void l(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        x6 x6Var = (x6) this.c;
        x6Var.h = charSequence;
        x6Var.i = onClickListener;
    }

    public jl1 m(int i) {
        x6 x6Var = (x6) this.c;
        x6Var.e = x6Var.a.getText(i);
        return this;
    }

    public b7 n() {
        b7 b7VarC = c();
        b7VarC.show();
        return b7VarC;
    }

    public void o(bs1 bs1Var) {
        String str;
        ul1 ul1Var = (ul1) this.c;
        int i = this.b;
        try {
            if (ul1Var.B == null) {
                throw null;
            }
            yk1 yk1Var = ul1Var.B;
            String packageName = ul1Var.z.getPackageName();
            switch (i) {
                case 2:
                    str = "LAUNCH_BILLING_FLOW";
                    break;
                case 3:
                    str = "ACKNOWLEDGE_PURCHASE";
                    break;
                case 4:
                    str = "CONSUME_ASYNC";
                    break;
                case 5:
                    str = "IS_FEATURE_SUPPORTED";
                    break;
                case 6:
                    str = "START_CONNECTION";
                    break;
                case 7:
                    str = "QUERY_PRODUCT_DETAILS_ASYNC";
                    break;
                default:
                    str = "QUERY_SKU_DETAILS_ASYNC";
                    break;
            }
            ol1 ol1Var = new ol1(bs1Var);
            wk1 wk1Var = (wk1) yk1Var;
            Parcel parcelA = wk1Var.a();
            parcelA.writeString(packageName);
            parcelA.writeString(str);
            int i2 = uk1.a;
            parcelA.writeStrongBinder(ol1Var);
            try {
                wk1Var.c.transact(1, parcelA, null, 1);
                parcelA.recycle();
            } catch (Throwable th) {
                parcelA.recycle();
                throw th;
            }
        } catch (Exception e) {
            ul1Var.D(107, 28, zl1.t);
            pn1.h("BillingClientTesting", "An error occurred while retrieving billing override.", e);
            bs1Var.d = true;
            fs1 fs1Var = bs1Var.b;
            if (fs1Var != null) {
                ds1 ds1Var = fs1Var.c;
                ds1Var.getClass();
                if (as1.g.a0(ds1Var, null, 0)) {
                    as1.c(ds1Var);
                    bs1Var.a = null;
                    bs1Var.b = null;
                    bs1Var.c = null;
                }
            }
        }
    }

    public /* synthetic */ jl1(ArrayList arrayList) {
        this.b = 0;
        this.c = arrayList;
    }

    public jl1(xm xmVar, int i) {
        xy0.d(xmVar);
        this.c = xmVar;
        this.b = i;
    }

    public /* synthetic */ jl1(int i, Object obj) {
        this.c = obj;
        this.b = i;
    }

    public jl1(Context context) {
        this(context, b7.g(context, 0));
    }

    public jl1(Context context, int i) {
        this.c = new x6(new ContextThemeWrapper(context, b7.g(context, i)));
        this.b = i;
    }
}
