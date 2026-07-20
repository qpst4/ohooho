package com.michaelflisar.changelog.internal;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import com.quickcursor.R;
import defpackage.i1;
import defpackage.kj;
import defpackage.lj;
import defpackage.z7;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class ChangelogActivity extends z7 implements View.OnClickListener {
    public kj A;
    public lj B = null;

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        i1.I(this);
    }

    @Override // defpackage.z7, defpackage.pm, defpackage.om, android.app.Activity
    public final void onCreate(Bundle bundle) {
        String str;
        int intExtra = getIntent().getIntExtra("theme", -1);
        if (intExtra > 0) {
            setTheme(intExtra);
        }
        super.onCreate(bundle);
        setContentView(R.layout.changelog_activity);
        this.A = (kj) getIntent().getParcelableExtra("builder");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (getIntent().getBooleanExtra("themeHasActionBar", false)) {
            toolbar.setVisibility(8);
        } else {
            D(toolbar);
        }
        String string = this.A.i;
        if (string == null) {
            try {
                str = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
                str = "";
            }
            string = getString(R.string.changelog_dialog_title, str);
        }
        Button button = (Button) findViewById(R.id.btRateMe);
        String str2 = this.A.k;
        if (str2 != null) {
            button.setText(str2);
        }
        if (!this.A.f) {
            button.setVisibility(8);
        }
        button.setOnClickListener(this);
        v().v(string);
        v().o(true);
        lj ljVar = new lj(this, (ProgressBar) findViewById(R.id.pbLoading), this.A.b((RecyclerView) findViewById(R.id.rvChangelog)), this.A);
        this.B = ljVar;
        ljVar.execute(new Void[0]);
    }

    @Override // defpackage.z7, android.app.Activity
    public final void onDestroy() {
        lj ljVar = this.B;
        if (ljVar != null) {
            ljVar.cancel(true);
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }
}
