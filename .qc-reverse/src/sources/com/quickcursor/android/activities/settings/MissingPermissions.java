package com.quickcursor.android.activities.settings;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.quickcursor.R;
import defpackage.d1;
import defpackage.f91;
import defpackage.g1;
import defpackage.j71;
import defpackage.lc1;
import defpackage.lw;
import defpackage.m91;
import defpackage.n3;
import defpackage.p2;
import defpackage.r1;
import defpackage.s71;
import defpackage.u2;
import defpackage.uv0;
import defpackage.wj;
import defpackage.xr;
import defpackage.xv0;
import defpackage.xw;
import defpackage.y2;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class MissingPermissions extends wj {
    public static final /* synthetic */ int D = 0;
    public RecyclerView C;

    public static ArrayList G() {
        ArrayList arrayList = new ArrayList();
        for (lw lwVar : xw.e.d("leftEdgeBar").d()) {
            if (!arrayList.contains(lwVar.b())) {
                arrayList.add(lwVar.b());
            }
        }
        for (lw lwVar2 : xw.e.d("topEdgeBar").d()) {
            if (!arrayList.contains(lwVar2.b())) {
                arrayList.add(lwVar2.b());
            }
        }
        for (lw lwVar3 : xw.e.d("rightEdgeBar").d()) {
            if (!arrayList.contains(lwVar3.b())) {
                arrayList.add(lwVar3.b());
            }
        }
        for (j71 j71Var : s71.e.c) {
            if (!arrayList.contains(j71Var.b())) {
                arrayList.add(j71Var.b());
            }
        }
        for (uv0 uv0Var : xv0.d.c.values()) {
            ArrayList arrayList2 = new ArrayList(uv0Var.l().l());
            arrayList2.addAll(uv0Var.d().c());
            arrayList2.add(uv0Var.e().d());
            int size = arrayList2.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList2.get(i);
                i++;
                m91 m91VarB = ((f91) obj).b();
                arrayList.add(m91VarB.n().b());
                arrayList.add(m91VarB.h().b());
                arrayList.addAll((Collection) m91VarB.k().stream().map(new u2(2)).collect(Collectors.toList()));
                arrayList.addAll((Collection) m91VarB.f().stream().map(new u2(2)).collect(Collectors.toList()));
            }
        }
        return arrayList;
    }

    public static ArrayList H() {
        ArrayList arrayList = new ArrayList();
        try {
            ArrayList arrayListG = G();
            int size = arrayListG.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayListG.get(i);
                i++;
                n3 n3Var = (n3) obj;
                int iJ = g1.j(n3Var);
                int[] iArr = g1.j;
                int i2 = 0;
                while (true) {
                    if (i2 >= 3) {
                        break;
                    }
                    if (!xr.y(iJ, iArr[i2])) {
                        i2++;
                    } else if (arrayList.stream().noneMatch(new d1(n3Var, 1))) {
                        arrayList.add(new p2(n3Var, null));
                    }
                }
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }

    @Override // defpackage.wj, defpackage.di0, defpackage.z7, defpackage.pm, defpackage.om, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        lc1.h0(this);
        setContentView(R.layout.missing_permissions_activity);
        Optional.ofNullable(v()).ifPresent(new defpackage.a(11));
        this.C = (RecyclerView) findViewById(R.id.recycler);
        this.C.setLayoutManager(new LinearLayoutManager(1));
    }

    @Override // android.app.Activity
    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    @Override // defpackage.wj, defpackage.di0, defpackage.z7, android.app.Activity
    public final void onResume() {
        super.onResume();
        ArrayList arrayListH = H();
        if (arrayListH.isEmpty()) {
            arrayListH.add(new p2(n3.noPermissionsNeeded, null));
        }
        this.C.setAdapter(new y2(this, arrayListH, new ArrayList(), new r1(14, this)));
    }
}
