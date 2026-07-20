package defpackage;

import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Intent;
import com.quickcursor.App;
import com.quickcursor.R;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class of0 extends g1 {
    public static final l3 k = new l3(of0.class, R.string.action_category_launch, R.string.action_value_launch_search, R.string.action_title_launch_search, R.string.action_detail_launch_search, R.drawable.icon_action_launch_search, 511, 0, Boolean.FALSE, null, null);

    @Override // defpackage.g1
    public final void g() {
        ComponentName globalSearchActivity = ((SearchManager) App.c.getSystemService("search")).getGlobalSearchActivity();
        if (globalSearchActivity == null) {
            si0.b("No search activity found.");
            return;
        }
        Intent intent = new Intent("android.search.action.GLOBAL_SEARCH");
        intent.addFlags(268435456);
        intent.setComponent(globalSearchActivity);
        intent.putExtra("query", "");
        intent.putExtra("select_query", true);
        try {
            App.c.startActivity(intent);
        } catch (Exception unused) {
            si0.b("Can't start search activity.");
        }
    }
}
