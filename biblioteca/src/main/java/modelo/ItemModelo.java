package modelo;

import java.util.HashMap;

import org.apache.log4j.Logger;

import entidade.Item;
import enumeador.MensagensEnum;
import excecao.ItemModeloException;
import excecao.ItemModeloValidacaoException;
import servico.UtilidadeServico;

public class ItemModelo {
	private HashMap<String, Item> hashDeItem;

	private Logger LOGGER = Logger.getLogger(ItemModelo.class);

	public ItemModelo() {
		this.hashDeItem = new HashMap<String, Item>();
	}

	/**
	 * @param item
	 *            Utilizado para inserir um Item no sistema.
	 * @throws ItemModeloException
	 *             Caso ocorra algum erro ao inserir, seja por valida��o ou outro
	 *             tipo, ser� disparado uma exeception como essa.
	 */
	public void inserirItem(Item item) throws ItemModeloException {
		try {
			validarItem(item);
			if (hashDeItem.containsKey(item.getTitulo())) {
				LOGGER.error(
						UtilidadeServico.gerarMensagemComErro(MensagensEnum.ITEM_MODELO_ERRO_AO_VALIDAR_ITEM.getValor(),
								MensagensEnum.ITEM_MODELO_ITEM_JA_CADASTRADO.getValor()));
				throw new ItemModeloException(MensagensEnum.ITEM_MODELO_ITEM_JA_CADASTRADO.getValor());
			}
			hashDeItem.put(item.getTitulo(), item);

		} catch (ItemModeloValidacaoException e) {
			LOGGER.error(UtilidadeServico
					.gerarMensagemComErro(MensagensEnum.ITEM_MODELO_ERRO_AO_VALIDAR_ITEM.getValor(), e.getMessage()));
			throw new ItemModeloException(e.getMessage());
		}
	}

	/**
	 * @param item
	 *            Item recebido para validacao
	 * @throws ItemModeloValidacaoException
	 *             Caso seja detectado que o Item est� inv�lido para iser��o, uma
	 *             exception como essa ser� disparada.
	 */
	private void validarItem(Item item) throws ItemModeloValidacaoException {
		if (item == null) {
			throw new ItemModeloValidacaoException(MensagensEnum.ITEM_MODELO_O_ITEM_NAO_PODE_SER_NULO.getValor());
		} else if (item.getNome() == (null)) {
			throw new ItemModeloValidacaoException(MensagensEnum.ITEM_MODELO_O_NOME_PODE_NAO_SER_NULO.getValor());
		} else if (item.getTitulo() == (null)) {
			throw new ItemModeloValidacaoException(MensagensEnum.ITEM_MODELO_O_TITULO_PODE_NAO_SER_NULO.getValor());
		} else if (item.getTipoItem() == (null)) {
			throw new ItemModeloValidacaoException(
					MensagensEnum.ITEM_MODELO_O_TIPO_DE_ITEM_NAO_PODE_SER_NULO.getValor());
		}
	}

	public Item recuperarItemPorCodigo(int cod) {
		// TODO: Recuperar um item por codigo
		return null;
	}

	public void atualizarItem(Item item) {
		// TODO: Atualizar dados do item
	}

	public void removerItem(int cod) {
		// TODO: Remover um item por codigo
	}
}
