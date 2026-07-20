package defpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.view.menu.ListMenuItemView;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ml0 extends bv {
    public final int n;
    public final int o;
    public bl0 p;
    public cl0 q;

    public ml0(Context context, boolean z) {
        super(context, z);
        if (1 == context.getResources().getConfiguration().getLayoutDirection()) {
            this.n = 21;
            this.o = 22;
        } else {
            this.n = 22;
            this.o = 21;
        }
    }

    @Override // defpackage.bv, android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        wk0 wk0Var;
        int headersCount;
        int iPointToPosition;
        int i;
        if (this.p != null) {
            ListAdapter adapter = getAdapter();
            if (adapter instanceof HeaderViewListAdapter) {
                HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                headersCount = headerViewListAdapter.getHeadersCount();
                wk0Var = (wk0) headerViewListAdapter.getWrappedAdapter();
            } else {
                wk0Var = (wk0) adapter;
                headersCount = 0;
            }
            cl0 cl0VarB = (motionEvent.getAction() == 10 || (iPointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) == -1 || (i = iPointToPosition - headersCount) < 0 || i >= wk0Var.getCount()) ? null : wk0Var.getItem(i);
            cl0 cl0Var = this.q;
            if (cl0Var != cl0VarB) {
                zk0 zk0Var = wk0Var.a;
                if (cl0Var != null) {
                    this.p.f(zk0Var, cl0Var);
                }
                this.q = cl0VarB;
                if (cl0VarB != null) {
                    this.p.i(zk0Var, cl0VarB);
                }
            }
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
        if (listMenuItemView != null && i == this.n) {
            if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
            }
            return true;
        }
        if (listMenuItemView == null || i != this.o) {
            return super.onKeyDown(i, keyEvent);
        }
        setSelection(-1);
        ListAdapter adapter = getAdapter();
        (adapter instanceof HeaderViewListAdapter ? (wk0) ((HeaderViewListAdapter) adapter).getWrappedAdapter() : (wk0) adapter).a.c(false);
        return true;
    }

    public void setHoverListener(bl0 bl0Var) {
        this.p = bl0Var;
    }

    @Override // defpackage.bv, android.widget.AbsListView
    public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
        super.setSelector(drawable);
    }
}
