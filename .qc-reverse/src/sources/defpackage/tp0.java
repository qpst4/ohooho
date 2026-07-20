package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class tp0 {
    public final Object[] a;
    public int b;

    public tp0(int i) {
        if (i > 0) {
            this.a = new Object[i];
        } else {
            zy.n("The max pool size must be > 0");
            throw null;
        }
    }

    public Object a() {
        int i = this.b;
        if (i <= 0) {
            return null;
        }
        int i2 = i - 1;
        Object[] objArr = this.a;
        Object obj = objArr[i2];
        obj.getClass();
        objArr[i2] = null;
        this.b--;
        return obj;
    }

    public void b(lb lbVar) {
        int i = this.b;
        Object[] objArr = this.a;
        if (i < objArr.length) {
            objArr[i] = lbVar;
            this.b = i + 1;
        }
    }

    public boolean c(Object obj) {
        obj.getClass();
        int i = this.b;
        int i2 = 0;
        while (true) {
            Object[] objArr = this.a;
            if (i2 >= i) {
                int i3 = this.b;
                if (i3 >= objArr.length) {
                    return false;
                }
                objArr[i3] = obj;
                this.b = i3 + 1;
                return true;
            }
            if (objArr[i2] == obj) {
                s1.f("Already in the pool!");
                return false;
            }
            i2++;
        }
    }

    public tp0() {
        this.a = new Object[256];
    }
}
