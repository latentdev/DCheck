package com.latentdev.d_check.Fragments;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.latentdev.d_check.Model.Ride;
import com.latentdev.d_check.R;
import com.latentdev.d_check.RideAdapter;
import com.latentdev.d_check.Model.Rides;
import com.latentdev.d_check.RideDetailActivity;
import com.latentdev.d_check.RideViewModel;
import com.latentdev.d_check.databinding.FragmentDisneylandBinding;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DisneylandFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DisneylandFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DisneylandFragment extends Fragment implements RideAdapter.OnItemClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_RIDES = "Rides";

    // TODO: Rename and change types of parameters
    private Rides model;
    private RecyclerView disneyRecyclerView;
    private FragmentDisneylandBinding binding;

    private OnFragmentInteractionListener mListener;

    public DisneylandFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment DisneylandFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DisneylandFragment newInstance(Rides rides) {
        DisneylandFragment fragment = new DisneylandFragment();
        Bundle args = new Bundle();

        //FIX THIS!!!!!
        args.putSerializable(ARG_RIDES, rides);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            model = (Rides) getArguments().getSerializable(ARG_RIDES);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_disneyland,container,false);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        binding.disneyrecyclerview.setLayoutManager(layoutManager);
        RideAdapter adapter = new RideAdapter(model.getDisneyland(), getContext());
        binding.disneyrecyclerview.setAdapter(adapter);
        adapter.setOnItemClickListener(this);
        View view = binding.getRoot();
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void OnItemClicked(View view, Ride ride) {
        Intent intent = new Intent(getActivity().getApplicationContext(),RideDetailActivity.class);
        intent.putExtra("ride", ride );
        getActivity().startActivity(intent);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
