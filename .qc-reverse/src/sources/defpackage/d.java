package defpackage;

import android.view.View;
import androidx.appcompat.widget.ActionBarContextView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements pg1 {
    public boolean a;
    public int b;
    public final View c;

    public d(FloatingActionButton floatingActionButton) {
        this.a = false;
        this.b = 0;
        this.c = floatingActionButton;
    }

    @Override // defpackage.pg1
    public void a() {
        if (this.a) {
            return;
        }
        ActionBarContextView actionBarContextView = (ActionBarContextView) this.c;
        actionBarContextView.g = null;
        super/*android.view.View*/.setVisibility(this.b);
    }

    @Override // defpackage.pg1
    public void b() {
        this.a = true;
    }

    @Override // defpackage.pg1
    public void c() {
        super/*android.view.View*/.setVisibility(0);
        this.a = false;
    }

    public d(ActionBarContextView actionBarContextView) {
        this.c = actionBarContextView;
        this.a = false;
    }
}
