package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ee extends in {
    public int i;
    public int j;
    public fe k;

    public boolean getAllowsGoneWidget() {
        return this.k.t0;
    }

    public int getMargin() {
        return this.k.u0;
    }

    public int getType() {
        return this.i;
    }

    @Override // defpackage.in
    public final void h(vn vnVar, boolean z) {
        int i = this.i;
        this.j = i;
        if (z) {
            if (i == 5) {
                this.j = 1;
            } else if (i == 6) {
                this.j = 0;
            }
        } else if (i == 5) {
            this.j = 0;
        } else if (i == 6) {
            this.j = 1;
        }
        if (vnVar instanceof fe) {
            ((fe) vnVar).s0 = this.j;
        }
    }

    public void setAllowsGoneWidget(boolean z) {
        this.k.t0 = z;
    }

    public void setDpMargin(int i) {
        this.k.u0 = (int) ((i * getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void setMargin(int i) {
        this.k.u0 = i;
    }

    public void setType(int i) {
        this.i = i;
    }
}
