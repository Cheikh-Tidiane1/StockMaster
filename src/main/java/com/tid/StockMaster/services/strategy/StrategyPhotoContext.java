package com.tid.StockMaster.services.strategy;
import com.flickr4java.flickr.FlickrException;
import com.tid.StockMaster.exception.ErrorCodes;
import com.tid.StockMaster.exception.InvalidOperationException;
import lombok.Setter;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service
public class StrategyPhotoContext {

    private BeanFactory beanFactory;
    private Strategy strategy;
    @Setter
    private String context;

    @Autowired
    public StrategyPhotoContext(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public Object savePhoto(String context, Integer id, InputStream photo, String title) throws FlickrException {
        determineContext(context);
        return this.strategy.savePhoto(id,photo,title);
    }

    private void determineContext(String context) {
        final String beanName = context + "context";
        switch (context) {
            case "article":
                this.strategy = beanFactory.getBean(beanName, SaveArticlePhoto.class);
                break;
            case "client":
                this.strategy = beanFactory.getBean(beanName, SaveClientPhoto.class);
                break;
            case "fournisseur":
                this.strategy = beanFactory.getBean(beanName, SaveFournisseurPhoto.class);
                break;
            case "entreprise":
                this.strategy = beanFactory.getBean(beanName, SaveEntreprisePhoto.class);
                break;
            case "utilisateur":
                this.strategy = beanFactory.getBean(beanName, SaveUtilisateurPhoto.class);
                break;
            default:
                throw new InvalidOperationException("Contexte inconnue pour l'enregistrement de la photo", ErrorCodes.UNKNOWN_CONTEXT);

        }
    }
}
