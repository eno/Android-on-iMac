package edu.mercy.phone;


public class PhoneCall extends ListActivity {
	/** Called when the activity is first created. */
	Uri CONTENT_URI;
	public SimpleCursorAdapter mAdapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Cursor c = getContentResolver().query(CONTENT_URI, null, null, null,
				null);
		startManagingCursor(c);

		String[] columns = new String[] { People.NAME };
		int[] names = new int[] { R.id.row_entry };

		mAdapter = new SimpleCursorAdapter(this, R.layout.main, c, columns,
				names);
		setListAdapter(mAdapter);
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		Intent i = new Intent(Intent.ACTION_CALL);

		Cursor c = (Cursor) mAdapter.getItem(position);
		long phoneId = c.getLong(c.getColumnIndex(CallLog));
		i.setData(CallLog.CONTENT_URI.addId(phoneId));
		startActivity(i);
	}
}