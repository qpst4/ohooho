package defpackage;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.quickcursor.R;
import com.quickcursor.android.views.settings.ActionsRecyclerView;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class x3 extends qt0 {
    public final /* synthetic */ List c;
    public final /* synthetic */ z3 d;
    public final /* synthetic */ sc0 e;

    public x3(List list, z3 z3Var, sc0 sc0Var) {
        this.c = list;
        this.d = z3Var;
        this.e = sc0Var;
    }

    @Override // defpackage.qt0
    public final int a() {
        return this.c.size();
    }

    @Override // defpackage.qt0
    public final void e(pu0 pu0Var, int i) {
        final y3 y3Var = (y3) pu0Var;
        ImageView imageView = y3Var.u;
        TextView textView = y3Var.t;
        j jVar = (j) this.c.get(i);
        if (jVar == null) {
            textView.setText("");
            imageView.setImageDrawable(null);
            return;
        }
        int i2 = jVar.b().iconId;
        View view = y3Var.a;
        textView.setText(lc1.K(jVar.b().titleId));
        if (i2 != 0) {
            imageView.setImageDrawable(jVar.d(imageView.getContext()));
        } else {
            imageView.setImageDrawable(null);
        }
        final int i3 = 0;
        final z3 z3Var = this.d;
        view.setOnClickListener(new View.OnClickListener() { // from class: u3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                int i4 = i3;
                y3 y3Var2 = y3Var;
                z3 z3Var2 = z3Var;
                switch (i4) {
                    case 0:
                        z3Var2.h(y3Var2.b());
                        break;
                    default:
                        z3Var2.g(y3Var2.b());
                        break;
                }
            }
        });
        view.setOnLongClickListener(new View.OnLongClickListener() { // from class: v3
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view2) {
                z3Var.j(y3Var.b());
                return true;
            }
        });
        AppCompatImageView appCompatImageView = y3Var.v;
        final sc0 sc0Var = this.e;
        appCompatImageView.setOnTouchListener(new View.OnTouchListener() { // from class: w3
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                sc0 sc0Var2 = sc0Var;
                t3 t3Var = sc0Var2.m;
                ActionsRecyclerView actionsRecyclerView = sc0Var2.r;
                t3Var.getClass();
                WeakHashMap weakHashMap = uf1.a;
                if ((t3.b(208947, actionsRecyclerView.getLayoutDirection()) & 16711680) == 0) {
                    Log.e("ItemTouchHelper", "Start drag has been called but dragging is not enabled");
                    return false;
                }
                y3 y3Var2 = y3Var;
                if (y3Var2.a.getParent() != sc0Var2.r) {
                    Log.e("ItemTouchHelper", "Start drag has been called with a view holder which is not a child of the RecyclerView which is controlled by this ItemTouchHelper.");
                    return false;
                }
                VelocityTracker velocityTracker = sc0Var2.t;
                if (velocityTracker != null) {
                    velocityTracker.recycle();
                }
                sc0Var2.t = VelocityTracker.obtain();
                sc0Var2.i = 0.0f;
                sc0Var2.h = 0.0f;
                sc0Var2.o(y3Var2, 2);
                return false;
            }
        });
        final int i4 = 1;
        y3Var.w.setOnClickListener(new View.OnClickListener() { // from class: u3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                int i42 = i4;
                y3 y3Var2 = y3Var;
                z3 z3Var2 = z3Var;
                switch (i42) {
                    case 0:
                        z3Var2.h(y3Var2.b());
                        break;
                    default:
                        z3Var2.g(y3Var2.b());
                        break;
                }
            }
        });
    }

    @Override // defpackage.qt0
    public final pu0 f(ViewGroup viewGroup, int i) {
        return new y3(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.action_recycler_item, viewGroup, false));
    }
}
