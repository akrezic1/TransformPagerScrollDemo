package hr.example.transformpagerscroll;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andro on 24.4.2015.
 */
public class RecyclerFragment extends Fragment {

    RecyclerView         recyclerView;
    RecyclerAdapter      adapter;
    private List<String> randomData;

    public static RecyclerFragment newInstance() {
        return new RecyclerFragment();
    }

    private void addData() {
        randomData = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            randomData.add("Test " + i);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycler, container, false);

        addData();

        recyclerView                        = (RecyclerView) view.findViewById(R.id.recycler);
        LinearLayoutManager layoutManager   = new LinearLayoutManager(getActivity());

        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new RecyclerAdapter(randomData);
        recyclerView.setAdapter(adapter);

        return view;
    }
}
