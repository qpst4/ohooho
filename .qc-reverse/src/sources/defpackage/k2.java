package defpackage;

import android.app.job.JobParameters;
import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.activity.a;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;
import com.quickcursor.R;
import com.quickcursor.android.activities.BuyProActivity;
import com.quickcursor.android.activities.ThanksProActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class k2 implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;

    public /* synthetic */ k2(Object obj, int i, Object obj2) {
        this.b = i;
        this.c = obj;
        this.d = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.b;
        int i2 = 3;
        int i3 = 4;
        int i4 = 2;
        boolean z = true;
        int i5 = 0;
        Object obj = this.d;
        Object obj2 = this.c;
        switch (i) {
            case 0:
                r2 r2Var = (r2) obj2;
                r2Var.I0 = new i((n3) obj);
                r2Var.h0(false, false);
                return;
            case 1:
                i8 i8Var = (i8) obj2;
                try {
                    ((Runnable) obj).run();
                    return;
                } finally {
                    i8Var.a();
                }
            case 2:
                ya yaVar = (ya) obj2;
                View view = (View) obj;
                try {
                    if (yaVar.o0 == 3) {
                        Pair pair = (Pair) view.getTag();
                        ComponentName componentName = new ComponentName((String) pair.first, (String) pair.second);
                        Intent intent = new Intent("android.intent.action.CREATE_SHORTCUT");
                        intent.setComponent(componentName);
                        wa waVar = new wa();
                        waVar.put("packageName", pair.first);
                        yaVar.t0 = waVar;
                        yaVar.A0.a(intent);
                    } else {
                        yaVar.t0 = view.getTag();
                        yaVar.h0(false, false);
                    }
                    return;
                } catch (Exception e) {
                    yaVar.t0 = null;
                    si0.b("Exception: " + e);
                    yb0.y(R.string.general_error_contact, 0);
                    return;
                }
            case 3:
                ya yaVar2 = (ya) obj2;
                Handler handler = (Handler) obj;
                List listA = Collections.EMPTY_LIST;
                try {
                    int iR = l11.r(yaVar2.o0);
                    if (iR == 0 || iR == 1) {
                        listA = (List) f01.x(yaVar2.o(), yaVar2.y0.booleanValue()).collect(Collectors.toList());
                    } else {
                        if (iR != 2) {
                            throw new IncompatibleClassChangeError();
                        }
                        listA = f01.A(yaVar2.o());
                    }
                } catch (Exception unused) {
                    si0.b("AppPicker List apps crash");
                }
                handler.post(new k2(yaVar2, i3, listA));
                return;
            case 4:
                ya yaVar3 = (ya) obj2;
                View view2 = yaVar3.q0;
                ((ViewGroup) view2).removeView(view2.findViewById(R.id.progressBar));
                yaVar3.s0.setLayoutManager(new LinearLayoutManager(1));
                y2 y2Var = new y2((List) obj, yaVar3.x0.booleanValue(), yaVar3.z0, new va(yaVar3, i5));
                yaVar3.r0 = y2Var;
                y2Var.h(yaVar3.w0.getText().toString().toLowerCase());
                yaVar3.s0.setAdapter(yaVar3.r0);
                return;
            case 5:
                ((pf) obj2).d((yq0) obj);
                return;
            case 6:
                o01 o01Var = (o01) obj2;
                ArrayList arrayList = (ArrayList) obj;
                ThanksProActivity thanksProActivity = (ThanksProActivity) o01Var.d;
                int i6 = o01Var.c;
                ThanksProActivity.a aVar = thanksProActivity.C;
                if (aVar != null) {
                    aVar.m0(arrayList, i6);
                    return;
                }
                return;
            case 7:
                ((sf) obj2).b.c((yq0) obj);
                return;
            case 8:
                BuyProActivity buyProActivity = (BuyProActivity) obj2;
                String str = (String) obj;
                int i7 = BuyProActivity.H;
                try {
                    if (buyProActivity.G.c.c()) {
                        si0.b("queryPurchaseHistoryAsync");
                        sf sfVar = buyProActivity.G;
                        wh whVar = new wh(buyProActivity, i2);
                        af afVar = sfVar.c;
                        String str2 = "inapp";
                        if (!afVar.c()) {
                            df dfVar = zl1.k;
                            afVar.w(2, 11, dfVar);
                            whVar.b(dfVar, null);
                        } else if (af.h(new rk1(afVar, str2, whVar, i4), 30000L, new vn1(afVar, 16, whVar), afVar.u(), afVar.l()) == null) {
                            df dfVarI = afVar.i();
                            afVar.w(25, 11, dfVarI);
                            whVar.b(dfVarI, null);
                        }
                    }
                    break;
                } catch (Exception unused2) {
                }
                buyProActivity.G.g(str, Boolean.TRUE);
                return;
            case 9:
                pm pmVar = (pm) obj2;
                int i8 = pm.t;
                pmVar.b.a(new hm((a) obj, pmVar));
                return;
            case 10:
                j81 j81Var = (j81) obj;
                j81Var.d++;
                ar arVar = (ar) ((sp1) obj2).c;
                arVar.e.b(arVar.p, j81Var);
                l60.a(arVar.b, j81Var.b, j81Var.c, true);
                return;
            case 11:
                er erVar = (er) obj2;
                Pair pair2 = (Pair) obj;
                float[] fArr = new float[9];
                ImageView imageView = erVar.b;
                imageView.getImageMatrix().getValues(fArr);
                float f = fArr[0];
                float f2 = fArr[4];
                Drawable drawable = imageView.getDrawable();
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = drawable.getIntrinsicHeight();
                erVar.e = Math.round(intrinsicWidth * f);
                erVar.f = Math.round(intrinsicHeight * f2);
                erVar.a(((Float) pair2.first).floatValue(), ((Float) pair2.second).floatValue());
                return;
            case 12:
                ((rr) obj2).d = 0L;
                ((Runnable) obj).run();
                return;
            case 13:
                int i9 = JobInfoSchedulerService.b;
                ((JobInfoSchedulerService) obj2).jobFinished((JobParameters) obj, false);
                return;
            case 14:
                sf sfVar2 = (sf) obj2;
                wj wjVar = (wj) obj;
                if (sfVar2.c.c()) {
                    sfVar2.d(new ar0(wjVar, sfVar2));
                    return;
                }
                return;
            case 15:
                ((i1) obj2).H((Typeface) obj);
                return;
            case 16:
                String str3 = jy0.k;
                ((jy0) obj2).f.takeScreenshot(0, Executors.newSingleThreadScheduledExecutor(), new gy0((iy0) obj));
                return;
            case 17:
                a11 a11Var = (a11) obj2;
                uv0 uv0VarA = xv0.d.a();
                z01 z01Var = new z01(((SharedPreferences) obj).getInt("triggerSize", 0), a11Var.l0.j(), a11Var.l0.i(), a11Var.l0.d(), a11Var.l0.c(), a11Var.l0.e(), a11Var.l0.f());
                if0 if0Var = ey0.b == 1 ? if0.p : if0.o;
                boolean z2 = a11Var.l0.k() == x01.left || a11Var.l0.k() == x01.both;
                if (a11Var.l0.k() != x01.right && a11Var.l0.k() != x01.both) {
                    z = false;
                }
                if0Var.u0(uv0VarA, z01Var, z2, z);
                a11Var.p0();
                return;
            case 18:
                ((ThanksProActivity) obj2).B.g((String) obj, Boolean.FALSE);
                return;
            default:
                ia1 ia1Var = (ia1) obj2;
                ia1Var.Z.c().remove((f91) obj);
                xv0.d.c();
                ia1Var.h0();
                ia1Var.Y.a(new s4(15));
                return;
        }
    }
}
