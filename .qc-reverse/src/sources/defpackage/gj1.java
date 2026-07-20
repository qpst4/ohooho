package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class gj1 extends yb0 {
    public final /* synthetic */ int s;

    @Override // defpackage.yb0
    public t7 a(Context context, Looper looper, a9 a9Var, Object obj, y60 y60Var, z60 z60Var) {
        switch (this.s) {
            case 0:
                a9Var.getClass();
                Integer num = (Integer) a9Var.f;
                Bundle bundle = new Bundle();
                bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", null);
                if (num != null) {
                    bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", num.intValue());
                }
                bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", false);
                bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", false);
                bundle.putString("com.google.android.gms.signin.internal.serverClientId", null);
                bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
                bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", false);
                bundle.putString("com.google.android.gms.signin.internal.hostedDomain", null);
                bundle.putString("com.google.android.gms.signin.internal.logSessionId", null);
                bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", false);
                return new q01(context, looper, a9Var, bundle, y60Var, z60Var);
            case 1:
                obj.getClass();
                throw new ClassCastException();
            default:
                return super.a(context, looper, a9Var, obj, y60Var, z60Var);
        }
    }

    @Override // defpackage.yb0
    public /* synthetic */ t7 b(Context context, Looper looper, a9 a9Var, Object obj, mj1 mj1Var, mj1 mj1Var2) {
        switch (this.s) {
            case 2:
                return new ik1(context, looper, a9Var, (r41) obj, mj1Var, mj1Var2);
            default:
                return super.b(context, looper, a9Var, obj, mj1Var, mj1Var2);
        }
    }
}
