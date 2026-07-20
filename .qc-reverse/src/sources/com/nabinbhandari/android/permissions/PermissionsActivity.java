package com.nabinbhandari.android.permissions;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import defpackage.fc0;
import defpackage.mp0;
import defpackage.sp1;
import defpackage.tl;
import defpackage.tt;
import defpackage.y2;
import defpackage.yb0;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class PermissionsActivity extends Activity {
    public static sp1 f;
    public ArrayList b;
    public ArrayList c;
    public ArrayList d;
    public mp0 e;

    public static String[] b(ArrayList arrayList) {
        int size = arrayList.size();
        String[] strArr = new String[size];
        for (int i = 0; i < size; i++) {
            strArr[i] = (String) arrayList.get(i);
        }
        return strArr;
    }

    public final void a() {
        sp1 sp1Var = f;
        finish();
        if (sp1Var != null) {
            sp1.x(getApplicationContext(), this.c);
        }
    }

    @Override // android.app.Activity
    public final void finish() {
        f = null;
        super.finish();
    }

    @Override // android.app.Activity
    public final void onActivityResult(int i, int i2, Intent intent) {
        if (i == 6739 && f != null) {
            fc0.h(this, b(this.b), this.e, f);
        }
        super.finish();
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setFinishOnTouchOutside(false);
        Intent intent = getIntent();
        if (intent == null || !intent.hasExtra("permissions")) {
            finish();
            return;
        }
        getWindow().setStatusBarColor(0);
        this.b = (ArrayList) intent.getSerializableExtra("permissions");
        mp0 mp0Var = (mp0) intent.getSerializableExtra("options");
        this.e = mp0Var;
        if (mp0Var == null) {
            this.e = new mp0();
        }
        this.c = new ArrayList();
        this.d = new ArrayList();
        ArrayList arrayList = this.b;
        int size = arrayList.size();
        int i = 1;
        int i2 = 0;
        boolean z = true;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            String str = (String) obj;
            if (checkSelfPermission(str) != 0) {
                this.c.add(str);
                if (shouldShowRequestPermissionRationale(str)) {
                    z = false;
                } else {
                    this.d.add(str);
                }
            }
        }
        if (this.c.isEmpty()) {
            sp1 sp1Var = f;
            finish();
            if (sp1Var != null) {
                ((y2) sp1Var.c).d();
                return;
            }
            return;
        }
        String stringExtra = intent.getStringExtra("rationale");
        if (z || TextUtils.isEmpty(stringExtra)) {
            fc0.A("No rationale.");
            requestPermissions(b(this.c), 6937);
            return;
        }
        fc0.A("Show rationale.");
        tl tlVar = new tl(2, this);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        this.e.getClass();
        builder.setTitle("Permissions Required").setMessage(stringExtra).setPositiveButton(R.string.ok, tlVar).setNegativeButton(R.string.cancel, tlVar).setOnCancelListener(new tt(i, this)).create().show();
    }

    @Override // android.app.Activity
    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (iArr.length == 0) {
            a();
            return;
        }
        this.c.clear();
        int i2 = 0;
        for (int i3 = 0; i3 < iArr.length; i3++) {
            if (iArr[i3] != 0) {
                this.c.add(strArr[i3]);
            }
        }
        if (this.c.size() == 0) {
            fc0.A("Just allowed.");
            sp1 sp1Var = f;
            finish();
            if (sp1Var != null) {
                ((y2) sp1Var.c).d();
                return;
            }
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = this.c;
        int size = arrayList4.size();
        int i4 = 0;
        while (i4 < size) {
            Object obj = arrayList4.get(i4);
            i4++;
            String str = (String) obj;
            if (shouldShowRequestPermissionRationale(str)) {
                arrayList3.add(str);
            } else {
                arrayList.add(str);
                if (!this.d.contains(str)) {
                    arrayList2.add(str);
                }
            }
        }
        if (arrayList2.size() <= 0) {
            if (arrayList3.size() > 0) {
                a();
                return;
            }
            if (f != null) {
                getApplicationContext();
                yb0.y(com.quickcursor.R.string.error_permission_not_granted, 0);
            }
            finish();
            return;
        }
        sp1 sp1Var2 = f;
        finish();
        if (sp1Var2 != null) {
            Context applicationContext = getApplicationContext();
            ArrayList arrayList5 = this.c;
            StringBuilder sb = new StringBuilder("Just set not to ask again:");
            int size2 = arrayList2.size();
            while (i2 < size2) {
                Object obj2 = arrayList2.get(i2);
                i2++;
                sb.append(" ");
                sb.append((String) obj2);
            }
            fc0.A(sb.toString());
            sp1.x(applicationContext, arrayList5);
        }
    }
}
