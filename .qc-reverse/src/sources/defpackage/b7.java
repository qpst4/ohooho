package defpackage;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.appcompat.app.AlertController$RecycleListView;
import androidx.core.widget.NestedScrollView;
import com.quickcursor.R;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class b7 extends qm implements DialogInterface, b8 {
    public y8 e;
    public final z8 f;
    public final a7 g;

    /* JADX WARN: Type inference failed for: r2v2, types: [z8] */
    public b7(ContextThemeWrapper contextThemeWrapper, int i) {
        int i2;
        int iG = g(contextThemeWrapper, i);
        if (iG == 0) {
            TypedValue typedValue = new TypedValue();
            contextThemeWrapper.getTheme().resolveAttribute(R.attr.dialogTheme, typedValue, true);
            i2 = typedValue.resourceId;
        } else {
            i2 = iG;
        }
        super(contextThemeWrapper, i2);
        this.f = new ge0() { // from class: z8
            @Override // defpackage.ge0
            public final boolean b(KeyEvent keyEvent) {
                return this.b.i(keyEvent);
            }
        };
        k8 k8VarE = e();
        if (iG == 0) {
            TypedValue typedValue2 = new TypedValue();
            contextThemeWrapper.getTheme().resolveAttribute(R.attr.dialogTheme, typedValue2, true);
            iG = typedValue2.resourceId;
        }
        ((y8) k8VarE).T = iG;
        k8VarE.d();
        this.g = new a7(getContext(), this, getWindow());
    }

    public static int g(Context context, int i) {
        if (((i >>> 24) & 255) >= 1) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    @Override // defpackage.qm, android.app.Dialog
    public final void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        b();
        y8 y8Var = (y8) e();
        y8Var.w();
        ((ViewGroup) y8Var.A.findViewById(android.R.id.content)).addView(view, layoutParams);
        y8Var.n.a(y8Var.m.getCallback());
    }

    public final Button d(int i) {
        a7 a7Var = this.g;
        if (i == -3) {
            return a7Var.o;
        }
        if (i == -2) {
            return a7Var.l;
        }
        if (i == -1) {
            return a7Var.i;
        }
        a7Var.getClass();
        return null;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        super.dismiss();
        e().f();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return fc0.o(this.f, getWindow().getDecorView(), this, keyEvent);
    }

    public final k8 e() {
        if (this.e == null) {
            i8 i8Var = k8.b;
            this.e = new y8(getContext(), getWindow(), this, this);
        }
        return this.e;
    }

    public final void f(Bundle bundle) {
        e().a();
        super.onCreate(bundle);
        e().d();
    }

    @Override // android.app.Dialog
    public final View findViewById(int i) {
        y8 y8Var = (y8) e();
        y8Var.w();
        return y8Var.m.findViewById(i);
    }

    public final void h(CharSequence charSequence) {
        super.setTitle(charSequence);
        e().l(charSequence);
    }

    public final boolean i(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Dialog
    public final void invalidateOptionsMenu() {
        e().b();
    }

    @Override // defpackage.qm, android.app.Dialog
    public final void onCreate(Bundle bundle) {
        int i;
        ListAdapter listAdapter;
        View viewFindViewById;
        f(bundle);
        a7 a7Var = this.g;
        a7Var.b.setContentView(a7Var.A);
        Context context = a7Var.a;
        Window window = a7Var.c;
        View viewFindViewById2 = window.findViewById(R.id.parentPanel);
        View viewFindViewById3 = viewFindViewById2.findViewById(R.id.topPanel);
        View viewFindViewById4 = viewFindViewById2.findViewById(R.id.contentPanel);
        View viewFindViewById5 = viewFindViewById2.findViewById(R.id.buttonPanel);
        ViewGroup viewGroup = (ViewGroup) viewFindViewById2.findViewById(R.id.customPanel);
        View view = a7Var.g;
        if (view == null) {
            view = null;
        }
        boolean z = view != null;
        if (!z || !a7.a(view)) {
            window.setFlags(131072, 131072);
        }
        if (z) {
            FrameLayout frameLayout = (FrameLayout) window.findViewById(R.id.custom);
            frameLayout.addView(view, new ViewGroup.LayoutParams(-1, -1));
            if (a7Var.h) {
                frameLayout.setPadding(0, 0, 0, 0);
            }
            if (a7Var.f != null) {
                ((LinearLayout.LayoutParams) ((lg0) viewGroup.getLayoutParams())).weight = 0.0f;
            }
        } else {
            viewGroup.setVisibility(8);
        }
        View viewFindViewById6 = viewGroup.findViewById(R.id.topPanel);
        View viewFindViewById7 = viewGroup.findViewById(R.id.contentPanel);
        View viewFindViewById8 = viewGroup.findViewById(R.id.buttonPanel);
        ViewGroup viewGroupB = a7.b(viewFindViewById6, viewFindViewById3);
        ViewGroup viewGroupB2 = a7.b(viewFindViewById7, viewFindViewById4);
        ViewGroup viewGroupB3 = a7.b(viewFindViewById8, viewFindViewById5);
        NestedScrollView nestedScrollView = (NestedScrollView) window.findViewById(R.id.scrollView);
        a7Var.r = nestedScrollView;
        nestedScrollView.setFocusable(false);
        a7Var.r.setNestedScrollingEnabled(false);
        TextView textView = (TextView) viewGroupB2.findViewById(android.R.id.message);
        a7Var.w = textView;
        if (textView != null) {
            CharSequence charSequence = a7Var.e;
            if (charSequence != null) {
                textView.setText(charSequence);
            } else {
                textView.setVisibility(8);
                a7Var.r.removeView(a7Var.w);
                if (a7Var.f != null) {
                    ViewGroup viewGroup2 = (ViewGroup) a7Var.r.getParent();
                    int iIndexOfChild = viewGroup2.indexOfChild(a7Var.r);
                    viewGroup2.removeViewAt(iIndexOfChild);
                    viewGroup2.addView(a7Var.f, iIndexOfChild, new ViewGroup.LayoutParams(-1, -1));
                } else {
                    viewGroupB2.setVisibility(8);
                }
            }
        }
        Button button = (Button) viewGroupB3.findViewById(android.R.id.button1);
        a7Var.i = button;
        l1 l1Var = a7Var.H;
        button.setOnClickListener(l1Var);
        boolean zIsEmpty = TextUtils.isEmpty(a7Var.j);
        Button button2 = a7Var.i;
        if (zIsEmpty) {
            button2.setVisibility(8);
            i = 0;
        } else {
            button2.setText(a7Var.j);
            a7Var.i.setVisibility(0);
            i = 1;
        }
        Button button3 = (Button) viewGroupB3.findViewById(android.R.id.button2);
        a7Var.l = button3;
        button3.setOnClickListener(l1Var);
        boolean zIsEmpty2 = TextUtils.isEmpty(a7Var.m);
        Button button4 = a7Var.l;
        if (zIsEmpty2) {
            button4.setVisibility(8);
        } else {
            button4.setText(a7Var.m);
            a7Var.l.setVisibility(0);
            i |= 2;
        }
        Button button5 = (Button) viewGroupB3.findViewById(android.R.id.button3);
        a7Var.o = button5;
        button5.setOnClickListener(l1Var);
        boolean zIsEmpty3 = TextUtils.isEmpty(a7Var.p);
        Button button6 = a7Var.o;
        if (zIsEmpty3) {
            button6.setVisibility(8);
        } else {
            button6.setText(a7Var.p);
            a7Var.o.setVisibility(0);
            i |= 4;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogCenterButtons, typedValue, true);
        if (typedValue.data != 0) {
            if (i == 1) {
                Button button7 = a7Var.i;
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button7.getLayoutParams();
                layoutParams.gravity = 1;
                layoutParams.weight = 0.5f;
                button7.setLayoutParams(layoutParams);
            } else if (i == 2) {
                Button button8 = a7Var.l;
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) button8.getLayoutParams();
                layoutParams2.gravity = 1;
                layoutParams2.weight = 0.5f;
                button8.setLayoutParams(layoutParams2);
            } else if (i == 4) {
                Button button9 = a7Var.o;
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) button9.getLayoutParams();
                layoutParams3.gravity = 1;
                layoutParams3.weight = 0.5f;
                button9.setLayoutParams(layoutParams3);
            }
        }
        if (i == 0) {
            viewGroupB3.setVisibility(8);
        }
        if (a7Var.x != null) {
            viewGroupB.addView(a7Var.x, 0, new ViewGroup.LayoutParams(-1, -2));
            window.findViewById(R.id.title_template).setVisibility(8);
        } else {
            a7Var.u = (ImageView) window.findViewById(android.R.id.icon);
            if (TextUtils.isEmpty(a7Var.d) || !a7Var.F) {
                window.findViewById(R.id.title_template).setVisibility(8);
                a7Var.u.setVisibility(8);
                viewGroupB.setVisibility(8);
            } else {
                TextView textView2 = (TextView) window.findViewById(R.id.alertTitle);
                a7Var.v = textView2;
                textView2.setText(a7Var.d);
                int i2 = a7Var.s;
                if (i2 != 0) {
                    a7Var.u.setImageResource(i2);
                } else {
                    Drawable drawable = a7Var.t;
                    if (drawable != null) {
                        a7Var.u.setImageDrawable(drawable);
                    } else {
                        a7Var.v.setPadding(a7Var.u.getPaddingLeft(), a7Var.u.getPaddingTop(), a7Var.u.getPaddingRight(), a7Var.u.getPaddingBottom());
                        a7Var.u.setVisibility(8);
                    }
                }
            }
        }
        boolean z2 = viewGroup.getVisibility() != 8;
        int i3 = (viewGroupB == null || viewGroupB.getVisibility() == 8) ? 0 : 1;
        boolean z3 = viewGroupB3.getVisibility() != 8;
        if (!z3 && (viewFindViewById = viewGroupB2.findViewById(R.id.textSpacerNoButtons)) != null) {
            viewFindViewById.setVisibility(0);
        }
        if (i3 != 0) {
            NestedScrollView nestedScrollView2 = a7Var.r;
            if (nestedScrollView2 != null) {
                nestedScrollView2.setClipToPadding(true);
            }
            View viewFindViewById9 = (a7Var.e == null && a7Var.f == null) ? null : viewGroupB.findViewById(R.id.titleDividerNoCustom);
            if (viewFindViewById9 != null) {
                viewFindViewById9.setVisibility(0);
            }
        } else {
            View viewFindViewById10 = viewGroupB2.findViewById(R.id.textSpacerNoTitle);
            if (viewFindViewById10 != null) {
                viewFindViewById10.setVisibility(0);
            }
        }
        AlertController$RecycleListView alertController$RecycleListView = a7Var.f;
        if (alertController$RecycleListView != null && (!z3 || i3 == 0)) {
            alertController$RecycleListView.setPadding(alertController$RecycleListView.getPaddingLeft(), i3 != 0 ? alertController$RecycleListView.getPaddingTop() : alertController$RecycleListView.b, alertController$RecycleListView.getPaddingRight(), z3 ? alertController$RecycleListView.getPaddingBottom() : alertController$RecycleListView.c);
        }
        if (!z2) {
            View view2 = a7Var.f;
            if (view2 == null) {
                view2 = a7Var.r;
            }
            if (view2 != null) {
                int i4 = z3 ? 2 : 0;
                View viewFindViewById11 = window.findViewById(R.id.scrollIndicatorUp);
                View viewFindViewById12 = window.findViewById(R.id.scrollIndicatorDown);
                WeakHashMap weakHashMap = uf1.a;
                mf1.b(view2, i3 | i4, 3);
                if (viewFindViewById11 != null) {
                    viewGroupB2.removeView(viewFindViewById11);
                }
                if (viewFindViewById12 != null) {
                    viewGroupB2.removeView(viewFindViewById12);
                }
            }
        }
        AlertController$RecycleListView alertController$RecycleListView2 = a7Var.f;
        if (alertController$RecycleListView2 == null || (listAdapter = a7Var.y) == null) {
            return;
        }
        alertController$RecycleListView2.setAdapter(listAdapter);
        int i5 = a7Var.z;
        if (i5 > -1) {
            alertController$RecycleListView2.setItemChecked(i5, true);
            alertController$RecycleListView2.setSelection(i5);
        }
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.g.r;
        if (nestedScrollView == null || !nestedScrollView.i(keyEvent)) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public final boolean onKeyUp(int i, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.g.r;
        if (nestedScrollView == null || !nestedScrollView.i(keyEvent)) {
            return super.onKeyUp(i, keyEvent);
        }
        return true;
    }

    @Override // defpackage.qm, android.app.Dialog
    public final void onStop() {
        super.onStop();
        y8 y8Var = (y8) e();
        y8Var.A();
        j1 j1Var = y8Var.o;
        if (j1Var != null) {
            j1Var.s(false);
        }
    }

    @Override // defpackage.qm, android.app.Dialog
    public final void setContentView(int i) {
        b();
        e().i(i);
    }

    @Override // android.app.Dialog
    public final void setTitle(int i) {
        super.setTitle(i);
        e().l(getContext().getString(i));
    }

    @Override // defpackage.qm, android.app.Dialog
    public final void setContentView(View view) {
        b();
        e().j(view);
    }

    @Override // defpackage.qm, android.app.Dialog
    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        b();
        e().k(view, layoutParams);
    }

    @Override // android.app.Dialog
    public final void setTitle(CharSequence charSequence) {
        h(charSequence);
        a7 a7Var = this.g;
        a7Var.d = charSequence;
        TextView textView = a7Var.v;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }
}
