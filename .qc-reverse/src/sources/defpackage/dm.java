package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class dm implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ pm c;

    public /* synthetic */ dm(pm pmVar, int i) {
        this.b = i;
        this.c = pmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.b;
        pm pmVar = this.c;
        switch (i) {
            case 0:
                pmVar.invalidateOptionsMenu();
                return;
            default:
                try {
                    super/*android.app.Activity*/.onBackPressed();
                    return;
                } catch (IllegalStateException e) {
                    if (!fc0.b(e.getMessage(), "Can not perform this action after onSaveInstanceState")) {
                        throw e;
                    }
                    return;
                } catch (NullPointerException e2) {
                    if (!fc0.b(e2.getMessage(), "Attempt to invoke virtual method 'android.os.Handler android.app.FragmentHostCallback.getHandler()' on a null object reference")) {
                        throw e2;
                    }
                    return;
                }
        }
    }
}
