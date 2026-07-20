package defpackage;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.appcompat.app.AlertController$RecycleListView;
import androidx.core.widget.NestedScrollView;
import com.quickcursor.R;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class a7 {
    public final int A;
    public final int B;
    public final int C;
    public final int D;
    public final int E;
    public final boolean F;
    public final y6 G;
    public final Context a;
    public final b7 b;
    public final Window c;
    public CharSequence d;
    public CharSequence e;
    public AlertController$RecycleListView f;
    public View g;
    public Button i;
    public CharSequence j;
    public Message k;
    public Button l;
    public CharSequence m;
    public Message n;
    public Button o;
    public CharSequence p;
    public Message q;
    public NestedScrollView r;
    public Drawable t;
    public ImageView u;
    public TextView v;
    public TextView w;
    public View x;
    public ListAdapter y;
    public boolean h = false;
    public int s = 0;
    public int z = -1;
    public final l1 H = new l1(1, this);

    public a7(Context context, b7 b7Var, Window window) {
        this.a = context;
        this.b = b7Var;
        this.c = window;
        y6 y6Var = new y6();
        y6Var.b = new WeakReference(b7Var);
        this.G = y6Var;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, zs0.e, R.attr.alertDialogStyle, 0);
        this.A = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        typedArrayObtainStyledAttributes.getResourceId(2, 0);
        this.B = typedArrayObtainStyledAttributes.getResourceId(4, 0);
        this.C = typedArrayObtainStyledAttributes.getResourceId(5, 0);
        this.D = typedArrayObtainStyledAttributes.getResourceId(7, 0);
        this.E = typedArrayObtainStyledAttributes.getResourceId(3, 0);
        this.F = typedArrayObtainStyledAttributes.getBoolean(6, true);
        typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 0);
        typedArrayObtainStyledAttributes.recycle();
        b7Var.e().h(1);
    }

    public static boolean a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    public static ViewGroup b(View view, View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    public final void c(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        Message messageObtainMessage = onClickListener != null ? this.G.obtainMessage(i, onClickListener) : null;
        if (i == -3) {
            this.p = charSequence;
            this.q = messageObtainMessage;
        } else if (i == -2) {
            this.m = charSequence;
            this.n = messageObtainMessage;
        } else if (i != -1) {
            zy.n("Button does not exist");
        } else {
            this.j = charSequence;
            this.k = messageObtainMessage;
        }
    }
}
