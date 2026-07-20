package defpackage;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class xo0 {
    public final DataSetObservable a = new DataSetObservable();
    public DataSetObserver b;

    public abstract void a(ViewGroup viewGroup, int i, Object obj);

    public abstract void b(ViewGroup viewGroup);

    public abstract int c();

    public abstract int d(Object obj);

    public CharSequence e(int i) {
        return null;
    }

    public float f(int i) {
        return 1.0f;
    }

    public abstract Object g(mg1 mg1Var, int i);

    public abstract boolean h(View view, Object obj);

    public final void i() {
        synchronized (this) {
            try {
                DataSetObserver dataSetObserver = this.b;
                if (dataSetObserver != null) {
                    dataSetObserver.onChanged();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.a.notifyChanged();
    }

    public void j(DataSetObserver dataSetObserver) {
        this.a.registerObserver(dataSetObserver);
    }

    public abstract void k(Parcelable parcelable, ClassLoader classLoader);

    public abstract Parcelable l();

    public abstract void m(mg1 mg1Var, int i, Object obj);

    public abstract void n(ViewGroup viewGroup);

    public void o(DataSetObserver dataSetObserver) {
        this.a.unregisterObserver(dataSetObserver);
    }
}
