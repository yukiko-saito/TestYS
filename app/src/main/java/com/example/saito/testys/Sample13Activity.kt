package com.example.saito.testys

import android.content.ContentValues
import android.database.DatabaseUtils
import android.database.sqlite.SQLiteDatabase
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import com.example.saito.testys.adapter.Sample09RecyclerViewAdapter
import com.example.saito.testys.adapter.TitleDetailRecyclerViewAdapter
import com.example.saito.testys.model.ItemData
import com.example.saito.testys.model.RowData
import java.util.ArrayList
import android.widget.Toast



class Sample13Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample13)

        // ActionBarのタイトルを変更
        this.supportActionBar?.title = getString(R.string.top_title)

        val rv = findViewById<RecyclerView>(R.id.TourSpotListRecyclerView)
        val adapter = TitleDetailRecyclerViewAdapter(this.createSpotDBDataset())
        rv.adapter = adapter
        adapter.setOnItemClickListener(object : TitleDetailRecyclerViewAdapter.OnItemClickListener {
            override fun onClick(view: View, data: ItemData) {
                Toast.makeText(applicationContext, data.title, Toast.LENGTH_SHORT).show()
            }
        })

        val llm = LinearLayoutManager(this)
        rv.layoutManager = llm

        rv.setHasFixedSize(true)


    }

    private fun createSpotDB(){

        // DBにデータをとりあえず直接書き込み
        if (helper == null)
            helper = SpotSQLiteHelper(this)

        if (db == null)
            db = helper?.writableDatabase

        writeSpotDB(db!!,"道の駅 雁の里せんなん",3,"美郷町金沢字下館124","019-1302","img_001_small","0182-37-3000","0182-37-3888","国道１３号線沿いにある、観光と交流の拠点です。地元産の新鮮な野菜や、加工品などの特産品、各種お土産品を取り揃えて皆様をお待ちしております。食事処もありますので、ぜひお立ち寄りください。","4月～10月　9：00～19：00、11月～3月　9：00～18：00","1月1日","各種","地元産野菜","http://www.gantaro.jp/")
        writeSpotDB(db!!,"美郷町ラベンダー園",4,"美郷町千屋字大台野1-4","019-1502","img_004_small","0187-85-3131","","雄大な奥羽山脈のすそ野に広がるラベンダー園。６月下旬から７月中旬のラベンダー祭期間中は、約２万株のラベンダーが辺り一面を紫色に染め、清涼感あふれる微香が漂います。美郷町オリジナル品種の白いラベンダー「美郷雪華」も必見です。","9：00～17：00","イベント期間中はなし","300円","ラベンダー摘み取り体験","http://www.town.misato.akita.jp/lavendermaturi/1160.html")
        writeSpotDB(db!!,"大台野広場",6,"美郷町千屋字大台野1-4","019-1502","img_005_small","0187-85-3131","","敷地内にはグラウンドゴルフ場や、大型遊具を設置している芝生広場もあり、ご家族で１日中楽しめるプレイスポットです。また、ラベンダー園も同じ敷地内にあり、ラベンダー祭の期間中は多くの家族連れで賑わいます。","9：00～17：00","なし／12月～4月クローズ","200円","グラウンド・ゴルフ等","http://www.town.misato.akita.jp/lavendermaturi/1160.html")
        writeSpotDB(db!!,"松・杉並木",8,"美郷町土崎字上野乙 地内","019-1541","img_032_small","","","旧千屋村の中心部から各集落に通じる6本の直線道路沿いに、赤松と杉あわせて400本以上が植えられています。心落ち着く美郷町自慢の並木道を散策してみてはいかがでしょうか。","日の出～日没","なし","無料","","http://www.town.misato.akita.jp/matusuginamiki/2638.html")
        writeSpotDB(db!!,"美郷町観光情報センター",9,"美郷町六郷字馬町83","019-1404","img_041_small","0187-84-0110","0187-84-3553","美郷町観光の拠点です。事前に予約するれば無料の「清水案内ガイド」が利用できます。美郷町イメージキャラクター「美郷のミズモ」グッズも豊富に取り揃えていますよ。","8：30～17：15","年末年始","各種","ミズモグッズ","http://www.rokugo-mizu.net/")

    }
    private fun createSpotDBDataset(): List<ItemData>{

        clearAllDB()

        createSpotDB()

        val dataset = ArrayList<ItemData>()

        if (helper == null)
            helper = SpotSQLiteHelper(this)

        if (db == null)
            db = helper!!.readableDatabase

        val cursor = db!!.query(
                getString(R.string.spot_db_table), arrayOf("spot_name", "address"), null, null, null, null, null
        )

        cursor.moveToFirst()
        for (i in 0 until cursor.count) {
            val data = ItemData()
            data.title = cursor.getString(0)
            data.detail = cursor.getString(1)
            dataset.add(data)
            Log.d("DATA: ", DatabaseUtils.dumpCursorToString(cursor))
            cursor.moveToNext()
        }
        cursor.close()

        return dataset
    }
    private fun createDataset(): List<ItemData> {

        val dataset = ArrayList<ItemData>()
        for (i in 0..10) {
            val data = ItemData()
            data.title = "羊が" + i + "匹"
            data.detail = "子羊が" + i + "匹"

            dataset.add(data)
        }
        return dataset
    }

    private var helper: SpotSQLiteHelper? = null
    private var db: SQLiteDatabase? = null

    @Throws(Exception::class)
    private fun writeSpotDB(db: SQLiteDatabase,
        spot_name: String, category_id: Int, address: String,postal_code:String,photo1:String,tel:String,fax:String,comment: String, opening_hours:String,closure:String,cost:String,characteristic:String,url:String){
        val values = ContentValues()

        values.put("spot_name",spot_name)
        values.put("category_id",category_id)
        values.put("address",address)
        values.put("postal_code",postal_code)
        values.put("photo1",photo1)
        values.put("tel",tel)
        values.put("fax",fax)
        values.put("comment",comment)
        values.put("opening_hours",opening_hours)
        values.put("closure",closure)
        values.put("cost",cost)
        values.put("characteristic",characteristic)
        values.put("url",url)

        db.insert(this.getString(R.string.spot_db_table), null, values)

    }

    @Throws(Exception::class)
    private fun readSpotListDB() {

        if (helper == null)
            helper = SpotSQLiteHelper(this)

        if (db == null)
            db = helper?.readableDatabase

        val cursor = db?.query(
                getString(R.string.spot_db_table), arrayOf("spot_name", "address"), null, null, null, null, null
        )
        cursor?.moveToFirst()
        //val sbuilder = StringBuilder()

        /*
        for (i in 0 until cursor.getCount()) {
            sbuilder.append(cursor.getString(0))
            sbuilder.append(": ")
            sbuilder.append(cursor.getInt(1))
            sbuilder.append("\n")
            cursor.moveToNext()
        }
        */
        cursor?.close()
        /*
        textView.setText(sbuilder.toString())
        */
    }

    @Throws(Exception::class)
    private fun clearAllDB() {
        if (helper == null)
            helper = SpotSQLiteHelper(this)

        if (db == null)
            db = helper?.readableDatabase

        helper?.onUpgrade(db!!, 1, 1)

    }

}
