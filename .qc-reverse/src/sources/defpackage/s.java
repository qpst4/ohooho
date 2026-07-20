package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class s extends fc0 {
    @Override // defpackage.fc0
    public final void G(t tVar, t tVar2) {
        tVar.b = tVar2;
    }

    @Override // defpackage.fc0
    public final void H(t tVar, Thread thread) {
        tVar.a = thread;
    }

    @Override // defpackage.fc0
    public final boolean e(u uVar, q qVar) {
        q qVar2 = q.b;
        synchronized (uVar) {
            try {
                if (uVar.c != qVar) {
                    return false;
                }
                uVar.c = qVar2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.fc0
    public final boolean f(u uVar, Object obj, Object obj2) {
        synchronized (uVar) {
            try {
                if (uVar.b != obj) {
                    return false;
                }
                uVar.b = obj2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.fc0
    public final boolean g(u uVar, t tVar, t tVar2) {
        synchronized (uVar) {
            try {
                if (uVar.d != tVar) {
                    return false;
                }
                uVar.d = tVar2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
