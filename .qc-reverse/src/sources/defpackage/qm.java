package defpackage;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import androidx.lifecycle.a;
import com.quickcursor.R;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class qm extends Dialog implements gg0, rx0 {
    public a b;
    public final qx0 c;
    public final androidx.activity.a d;

    public qm(Context context, int i) {
        super(context, i);
        this.c = new qx0(this);
        this.d = new androidx.activity.a(new c(15, this));
    }

    public static void a(qm qmVar) {
        super.onBackPressed();
    }

    @Override // android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        view.getClass();
        b();
        super.addContentView(view, layoutParams);
    }

    public final void b() {
        Window window = getWindow();
        window.getClass();
        View decorView = window.getDecorView();
        decorView.getClass();
        decorView.setTag(R.id.view_tree_lifecycle_owner, this);
        Window window2 = getWindow();
        window2.getClass();
        View decorView2 = window2.getDecorView();
        decorView2.getClass();
        decorView2.setTag(R.id.view_tree_on_back_pressed_dispatcher_owner, this);
        Window window3 = getWindow();
        window3.getClass();
        View decorView3 = window3.getDecorView();
        decorView3.getClass();
        decorView3.setTag(R.id.view_tree_saved_state_registry_owner, this);
    }

    @Override // defpackage.rx0
    public final e8 c() {
        return (e8) this.c.c;
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        this.d.d();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 33) {
            OnBackInvokedDispatcher onBackInvokedDispatcher = getOnBackInvokedDispatcher();
            onBackInvokedDispatcher.getClass();
            androidx.activity.a aVar = this.d;
            aVar.getClass();
            aVar.e = onBackInvokedDispatcher;
            aVar.e(aVar.g);
        }
        this.c.c(bundle);
        a aVar2 = this.b;
        if (aVar2 == null) {
            aVar2 = new a(this);
            this.b = aVar2;
        }
        aVar2.d(yf0.ON_CREATE);
    }

    @Override // android.app.Dialog
    public final Bundle onSaveInstanceState() {
        Bundle bundleOnSaveInstanceState = super.onSaveInstanceState();
        bundleOnSaveInstanceState.getClass();
        this.c.d(bundleOnSaveInstanceState);
        return bundleOnSaveInstanceState;
    }

    @Override // android.app.Dialog
    public final void onStart() {
        super.onStart();
        a aVar = this.b;
        if (aVar == null) {
            aVar = new a(this);
            this.b = aVar;
        }
        aVar.d(yf0.ON_RESUME);
    }

    @Override // android.app.Dialog
    public void onStop() {
        a aVar = this.b;
        if (aVar == null) {
            aVar = new a(this);
            this.b = aVar;
        }
        aVar.d(yf0.ON_DESTROY);
        this.b = null;
        super.onStop();
    }

    @Override // defpackage.gg0
    public final a p() {
        a aVar = this.b;
        if (aVar != null) {
            return aVar;
        }
        a aVar2 = new a(this);
        this.b = aVar2;
        return aVar2;
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        view.getClass();
        b();
        super.setContentView(view);
    }

    @Override // android.app.Dialog
    public void setContentView(int i) {
        b();
        super.setContentView(i);
    }

    @Override // android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        view.getClass();
        b();
        super.setContentView(view, layoutParams);
    }
}
