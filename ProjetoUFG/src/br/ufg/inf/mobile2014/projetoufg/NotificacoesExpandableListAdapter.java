package br.ufg.inf.mobile2014.projetoufg;

import android.app.Activity;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckedTextView;
import android.widget.TextView;
import android.widget.Toast;

public class NotificacoesExpandableListAdapter extends BaseExpandableListAdapter {
	// SparseArray parece ser mais eficiente para mapear integer para object
	private final SparseArray<GrupoExpandableList> grupos;
	public LayoutInflater inflater;
	public Activity activity;
	
	public NotificacoesExpandableListAdapter(Activity act, SparseArray<GrupoExpandableList> grupos) {
		activity = act;
		this.grupos = grupos;
		inflater = act.getLayoutInflater();
	}
	
	@Override
	public Object getChild(int grupoPosicao, int childPosicao) {
		return grupos.get(grupoPosicao).children.get(childPosicao);
	}

	@Override
	public long getChildId(int grupoPosicao, int childPosicao) {
		return 0;
	}

	@Override
	public View getChildView(int grupoPosicao, final int childPosicao, boolean isLastChild, View convertView,
			ViewGroup parent) {
		final String children = (String) getChild(grupoPosicao, childPosicao);
	    TextView texto = null;
	    if (convertView == null) {
	      convertView = inflater.inflate(R.layout.listrow_detalhes, null);
	    }
	    texto = (TextView) convertView.findViewById(R.id.textViewDetalhes);
	    texto.setText(children);
	    convertView.setOnClickListener(new OnClickListener() {
	      @Override
	      public void onClick(View v) {
	        Toast.makeText(activity, children, Toast.LENGTH_SHORT).show();
	      }
	    });
	    return convertView;
	}

	@Override
	public int getChildrenCount(int grupoPosicao) {
		return grupos.get(grupoPosicao).children.size();
	}

	@Override
	public Object getGroup(int grupoPosicao) {
		return grupos.get(grupoPosicao);
	}

	@Override
	public int getGroupCount() {
		return grupos.size();
	}

	@Override
	public long getGroupId(int grupoPosicao) {
		return 0;
	}

	@Override
	public View getGroupView(int grupoPosicao, boolean isExpanded, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.listrow_group, null);
		}
		GrupoExpandableList grupo = (GrupoExpandableList) getGroup(grupoPosicao);
		((CheckedTextView) convertView).setText(grupo.string);
		((CheckedTextView) convertView).setChecked(isExpanded);
		return convertView;
	}

	@Override
	public boolean hasStableIds() {
		return false;
	}

	@Override
	public boolean isChildSelectable(int grupoPosicao, int childPosicao) {
		return false;
	}
	
	@Override
	public void onGroupCollapsed(int grupoPosicao) {
		super.onGroupCollapsed(grupoPosicao);
	}
	
	@Override
	public void onGroupExpanded(int grupoPosicao) {
	    super.onGroupExpanded(grupoPosicao);
	}

}
