package org.revo.Service;

import org.revo.Domain.Stater;

import java.util.List;

public interface StaterService {
    Stater state(Stater stater);

    List<Stater> states();
}
