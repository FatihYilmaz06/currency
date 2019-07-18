package fthylmz.currently;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class lastResponse extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_response);
        public class DatabaseHelper extends SQLiteOpenHelper {

            private static final int DATABASE_VERSION = 1;
            private static final String DB_NAME = "test3";
            private static final String DB_PATH = "/data/data/com.example.test/databases/";
            private static final String TABLE = "HighscoresList";

            // Table columns names.
            private static final String RANK = "_id";
            private static final String SCORE = "score";
            private static final String PERCENTAGE = "percentage";

            TableLayout table;
            TableRow rowHeader, row1, row2, row3, row4, row5, row6, row7, row8, row9, row10;
            TextView rank, percentage, score;

            private SQLiteDatabase db;

            public DatabaseHelper(Context context) {
                super(context, DB_NAME, null, DATABASE_VERSION);
                db = getWritableDatabase();

                TableLayout table = new TableLayout(context);

                TableRow rowHeader = new TableRow(context);
                TableRow row1 = new TableRow(context);

                TextView rank = new TextView(context);
                TextView percentage = new TextView(context);
                TextView score = new TextView(context);
                TextView r1r = new TextView(context);
                TextView r1p = new TextView(context);
                TextView r1s = new TextView(context);

                rowHeader.addView(rank);
                rowHeader.addView(percentage);
                rowHeader.addView(score);

                table.addView(rowHeader);
                table.addView(row1);
            }
        }

    }
}
